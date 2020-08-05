package com.hb.distributed;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class RpcDemo {
	public static void main(String[] args) {
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					RpcExporter.exporter("localhost", 8088);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}).start();
		RpcImporter<EchoService> importer = new RpcImporter();
		EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
		System.out.println(echo.echo("Are you ok?"));
	}
}

interface EchoService {
	String echo(String ping);
}

class EchoServiceImpl implements EchoService {
	public String echo(String ping) {
		return ping != null ? ping + "-->im ok" : "im ook";
	}
}

// 服务发布者
class RpcExporter {
	// Runtime.getRuntime().availableProcessors()获取cpu核心数
	static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void exporter(String hostName, int port) throws Exception {
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(hostName, port));
		try {
			while (true) {
				executor.execute(new ExporterTask(server.accept()));
			}
		} finally {
			server.close();
		}
	}

	static class ExporterTask implements Runnable {
		Socket client = null;

		public ExporterTask() {

		}

		public ExporterTask(Socket socket) {
			client = socket;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			ObjectInputStream input = null;
			ObjectOutputStream output = null;
			try {
				input = new ObjectInputStream(client.getInputStream());
				String interfaceName = input.readUTF();
				Class<?> service = Class.forName(interfaceName);
				String methodName = input.readUTF();
				Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
				Object[] arguments = (Object[]) input.readObject();
				Method method = service.getMethod(methodName, parameterTypes);
				Object result = method.invoke(service.newInstance(), arguments);
				output = new ObjectOutputStream(client.getOutputStream());
				output.writeObject(result);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (input != null) {
					try {
						input.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (client != null) {
					try {
						client.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}

class RpcImporter<S> {
	@SuppressWarnings("unchecked")
	public S importer(final Class<?> serviceClass, final InetSocketAddress addr) {
		return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(),
				new Class<?>[] { serviceClass.getInterfaces()[0] }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						Socket socket = null;
						ObjectInputStream input = null;
						ObjectOutputStream output = null;
						try {
							socket = new Socket();
							socket.connect(addr);
							output = new ObjectOutputStream(socket.getOutputStream());
							output.writeUTF(serviceClass.getName());
							output.writeUTF(method.getName());
							output.writeObject(method.getParameterTypes());
							output.writeObject(args);
							input = new ObjectInputStream(socket.getInputStream());
							return input.readObject();

						} finally {
							if (output != null) {
								try {
									output.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							if (input != null) {
								try {
									input.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							if (socket != null) {
								try {
									socket.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				});
	}
}

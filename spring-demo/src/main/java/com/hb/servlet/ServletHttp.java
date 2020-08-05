package com.hb.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//
public class ServletHttp {
	public static final String WEB_ROOT = System.getProperty("user.dir")+File.separator + "webroot";
	
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	private boolean shutdown = false;
	public static void main(String[] args) {
		ServletHttp server = new ServletHttp();
		server.await();
	}
	
	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		while(!shutdown) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			
				try {
					socket = serverSocket.accept();
					input = socket.getInputStream();
					output = socket.getOutputStream();
				
	//				Request request = new Request(input);
					ServletRequestTest request = new ServletRequestTest(input);
					request.parse();
					
					ServletResponseTest response = new ServletResponseTest(output);
					response.setRequest(request);
//					response.sendStaticResource();
					
					if(request.getUri().startsWith("/servlet/")) {
						ServletProcess processor = new ServletProcess();
						processor.process(request, response);
					}else {
						StaticResourceProcessor processor = new StaticResourceProcessor(request, response);
					}
					
					socket.close();
					
					shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
		}
	}
}

package com.hb.connector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 主要 负责 连接，接收http请求
 * @author uname
 *
 */
public class HttpConnector implements Runnable{

	boolean stopped = false ;
	ServerSocket servletSocket = null;
	public void run() {
		try {
			servletSocket = new  ServerSocket(8080,1,InetAddress.getByName("127.0.0.1"));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!stopped) {
			Socket  socket = null;
			try {
				socket = servletSocket.accept();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpProcessor httpProcessor = new  HttpProcessor (this);
			httpProcessor.process(socket);
		}

	}
	public void  start(){
		Thread thread = new Thread(this);
		thread.run();
	}
}

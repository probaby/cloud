package com.hb.connector;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 1 处理uri
 * 2 处理参数
 * @author uname
 *
 */
public class HttpProcessor {
	HttpConnector httpConnector = null; 
	HttpRequest request = null;
	HttpResponse response = null; 
	
	public HttpProcessor(HttpConnector connector){
		httpConnector = connector;
	}
	/**
	 * 对socket进行处理得到 输入流输出流，并装入request，response
	 * @param socket
	 */
	public void process(Socket socket){
		SocketInputStream socketInputStream = null;
		OutputStream outputStream = null;

		try {
			socketInputStream = new SocketInputStream(socket.getInputStream(),2048);
			outputStream = socket.getOutputStream();
			
			request = new HttpRequest(socketInputStream);
			response = new HttpResponse(outputStream);
			
			response.setRequest(request);
			response.setHeader("server", "container");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void parseRequest(SocketInputStream input,OutputStream output){
		
	}
	public void parseHeaders(SocketInputStream input){
		
	}
}

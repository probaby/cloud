package com.hb.connector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

public class HttpProcess {
	private void process(Socket socket) {
		// TODO 生成套接字
		InputStream input = null;
		OutputStream output = null;
		
		try {
			 input = socket.getInputStream();
			 output = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//HttpServletRequest request = new HttpServletRequest();
		Response response = null;
		
	}
}

package com.hb.socket;

import java.io.IOException;
import java.io.InputStream;

public class SocketRequest {
	private InputStream input;
	private String uri;
	
	public SocketRequest(InputStream input) {
		this.input = input; 
	}
	
	public void parse() {
		StringBuffer request = new StringBuffer(2048);
		int i;
		byte[] buffer = new byte[2048];
		try {
			i = input.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			i = -1;
		}
		for (int j = 0; j<i; j++){
			request.append((char) buffer[j]); 
		}
		System.out.print(request.toString());
		uri = parseUri(request.toString());
	}
	
	private String parseUri(String requestString) {
		//TODO 拼接出静态文件的名字
		int index1,index2;
		index1 = requestString.indexOf(' ');
		if(index1 != -1) {
			index2 = requestString.indexOf(' ',index1+1);
			if(index2 > index1) {
				return requestString.substring(index1+1,index2);
			}
		}
		return null;
	}
	
	public String getUri() {
		return uri;
	}
	
}

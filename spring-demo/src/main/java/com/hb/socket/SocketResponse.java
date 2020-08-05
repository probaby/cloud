package com.hb.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SocketResponse {
	private static final int BUFFER_SIZE = 1024;
	SocketRequest request;
	OutputStream output;
	
	public SocketResponse(OutputStream output) {
		this.output = output;
	}
	
	public void setRequest (SocketRequest request) {
		this.request = request;
	}
	
	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
		File file = new File(SocketTest.WEB_ROOT,request.getUri());
			if(file.exists()) {
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0,BUFFER_SIZE);
				while (ch != -1) {
					output.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
			}else {
				String errorMessage = "HTTP/1.1 404" + "<h1> file not found </h1>";
				output.write(errorMessage.getBytes());
			}
		}catch(Exception e) {
			System.out.print(e.toString());
		}
		finally {
			if (fis != null) {
				fis.close();
			}
		}
	}

}

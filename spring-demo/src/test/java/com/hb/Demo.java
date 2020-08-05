package com.hb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;

public class Demo {
	private static boolean b;
	public static void main(String[] args) {
//		Timestamp ts = new  Timestamp(System.currentTimeMillis());
//		System.out.println("ts"+ts.toString());
		System.out.println(b);
		String time = System.currentTimeMillis()+"";
		String time1 = time.substring(0, 19);
		String time2 = time.substring(0, 10);
		File file = new  File("f:"+File.separator+"demo");
		if(file==null){
			file.mkdirs();
		}
		String fileName = file.getAbsolutePath()+File.separator+"demo.txt";
		PrintWriter write = null;
		try {
			write = new PrintWriter(new  FileWriter(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		write.write(time);
		write.write(time1);
		write.write(time2);
		write.flush();		
	}
}

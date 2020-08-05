package com.hb.serialzable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

 class Persion implements Serializable{
	private static final long serialVersionUID = 2L;
	
	private transient int id;
	private String name;
	private String email;
	
	public Persion(int id,String name,String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString(){
		return "persion:{"+id+name+email+"}";
	}
}
 public class SerialzableDemo{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("d://a.txt");
		try {
			wirte(file);
			read(file);
			int a = DemoB.a;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public static void wirte(File file) throws Exception{
		
		ObjectOutputStream outStream = new ObjectOutputStream(new  FileOutputStream(file));
		outStream.writeObject(new Persion(1, "aa", "bb"));
		//outStream.flush();
		outStream.close();
	}
	
	public static void read(File file) throws Exception{
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
		Object obj = inputStream.readObject();
		inputStream.close();
		System.out.println(obj);
	}
}
 abstract class Demo{
	  int a = 1;
	  abstract void aa();
 }
 
 class DemoB{
	 static int a =1 ;
	 public DemoB(){
		 System.out.println("a");
	 }
 }

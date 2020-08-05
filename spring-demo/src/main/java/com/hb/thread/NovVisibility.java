package com.hb.thread;

public class NovVisibility {
	private static boolean read = false;
	private static int number = 0;
	
	static class ReadNumber extends Thread{
		public void run(){
			while(read)
				Thread.yield();
			System.out.println(number);
		}
	} 
	public static void main(String[] args) {
		new ReadNumber().run();
		number = 40;
		read = true;
	}
}

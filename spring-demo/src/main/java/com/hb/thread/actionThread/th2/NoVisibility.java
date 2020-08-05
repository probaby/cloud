package com.hb.thread.actionThread.th2;

public class NoVisibility {
	private static int c = 100;
	private static class threada extends Thread{
		@Override
		public void run(){
			int i=50;
			while(--i>0)
			c++;
			System.out.println(c);
		}
	}
	private static class threadb extends Thread{
		@Override
		public void run(){
			int i=50;
			while(--i>0)
			c--;
			System.out.println(c);
		}
	}
	public static void main(String[] args) {
		new threada().start();
		new threadb().start();
		System.out.println(c);

		
	}
}

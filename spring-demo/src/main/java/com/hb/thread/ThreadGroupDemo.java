package com.hb.thread;

public class ThreadGroupDemo {
	static class ThreadDemo implements Runnable {
		
		public void run() {
			while(true){
				
			
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getThreadGroup().getName());
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException  {
		ThreadGroup th = new  ThreadGroup("d1");
		Thread thread = new Thread(th,new ThreadDemo(),"t1");
		Thread thread2 = new Thread(th,new ThreadDemo(),"t2");
		thread.setDaemon(true);
		thread2.setDaemon(true);
		thread2.setPriority(10);
		thread.setPriority(9);
		thread.start();
		thread2.start();
		Thread.currentThread().sleep(2000);
		
	}
}

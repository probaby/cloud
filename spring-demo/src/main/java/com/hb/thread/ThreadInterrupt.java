package com.hb.thread;

public class ThreadInterrupt {
	static class ThreadDemo implements Runnable{
		public void run() {
			while(true){
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("break thread");
					break;
				}
				System.out.println(System.currentTimeMillis());
			}
		}
	}
	
	public static void main(String[] args) {
		Thread s = new Thread(new ThreadDemo());
		s.start();
		try {
			s.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.interrupt();
	}
	
}

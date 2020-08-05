package com.hb.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWaitNotify {
	static AtomicInteger i = new AtomicInteger(0) ;
	static class ThreadDemo implements Runnable {
		public void  run() { 
			synchronized(i){
				System.out.println(System.currentTimeMillis()+"t1 s");
				try {
					i.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis()+"t1 e");
			}
		}
	}
	static class ThreadDemo2 implements Runnable {
		public void  run() { 
			synchronized(i){
				System.out.println(System.currentTimeMillis()+"t2 s");
				try {
					i.notify();
					Thread.currentThread().sleep(2000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis()+"t2 e");
				
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadDemo());
		Thread t2 = new Thread(new ThreadDemo2());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(System.currentTimeMillis()+"end ");
		
	}
}

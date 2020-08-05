package com.hb.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo implements Runnable{
	public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId() + ": " + System.currentTimeMillis());
	}
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		ThreadPoolDemo tpd = new ThreadPoolDemo();
		for (int i = 0;i < 10 ; i++) {
			executor.submit(tpd);
		}
	}
}

class A{
	
}
class B extends A{
	
}
class C extends B{
	public static void main(String[] args) {
		B b = new B();
		C a = (C)b;
	}
}

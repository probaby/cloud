package com.hb.thread;

import java.util.Currency;

class MyThread0 extends Thread{
	int count=5;
	public MyThread0 (){
		
		System.out.println("System "+Thread.currentThread().getName());
		System.out.println("System "+Thread.currentThread().isAlive());
		System.out.println("-------------------------");
		System.out.println("System "+this.getName());
		System.out.println("System "+this.isAlive());
	}
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("******************************");
		System.out.println("System "+Thread.currentThread().getName());
		System.out.println("System "+Thread.currentThread().isAlive());
		System.out.println("-------------------------");
		System.out.println("System "+this.getName());
		System.out.println("System "+this.isAlive());
		System.out.println("%%%%%%%%%%%%%%%%%%%%%");
	}
}

public class MyThread {
	public static void main(String[] args) {
		
		MyThread0 me = new MyThread0();
//		MyThread0 me2 = new MyThread0();
//		MyThread0 me3 = new MyThread0();
//		Thread thread = new Thread(me);
//		Thread thread2 = new Thread(me);
//		Thread thread3 = new Thread(me);
//		Thread thread4 = new Thread(me);
//		Thread thread5 = new Thread(me);
		Thread thread6 = new Thread(me);
//		thread.start();
//		thread2.start();
//		thread3.start();
//		thread4.start();
//		thread5.start();
		me.start();
//		thread6.start();
		
		System.out.println(Thread.currentThread().getName());
	
	}
}

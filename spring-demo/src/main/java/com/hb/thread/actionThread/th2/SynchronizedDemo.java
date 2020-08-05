package com.hb.thread.actionThread.th2;

import java.util.concurrent.atomic.AtomicLong;



public class SynchronizedDemo {

	public static void main(String[] args) {
		Thread thread = new Thread(new runRun());
		Thread thread1 = new Thread(new runRun());
		Thread thread2 = new Thread(new runRun());
		Thread thread3 = new Thread(new runRun());
	}
	
}
class AddSome {
	private static AddSome addSome;
	public static AddSome getAddSome(){
		
		if(addSome==null){
			addSome = new AddSome();
		}
		return addSome;
	}
	private AtomicLong al ;
	public void service(){
		al.getAndIncrement();
	}
}
class runRun implements Runnable {
	public void run() {
		AddSome.getAddSome().service();
	}
}


package com.hb.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable{
	ReentrantLock lock1 = new ReentrantLock();
	ReentrantLock lock2 = new ReentrantLock();
	int lock;
	public LockDemo(int lock){
		this.lock = lock;
	}
	public void run(){
		if(lock==1){
			try {
				lock1.lockInterruptibly();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
	}
}

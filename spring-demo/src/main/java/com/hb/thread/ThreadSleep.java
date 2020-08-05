package com.hb.thread;

class Some extends Thread{
	static int i=0;
	static int y=0;
	@Override
	public void run(){
		for (int i = 0; i < 100; i++) {
			System.out.println("停止之前"+i);
	
				try {
					System.out.println("H停止了没"+i+this.interrupted()+" show ");
//					if(this.isInterrupted()){
//						System.out.println("停止之后"+i);
//						
//					}
					
					
//					Thread.sleep(10000);
//					System.out.println("停止之后"+i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					this.interrupt();
					System.out.println(this.isInterrupted());
					e.printStackTrace();
				}
				
				
			
		}
		System.out.println("for 之后");
//		i=1;
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		y=1;
//		System.out.println(i+"add "+y);
	}
}

public class ThreadSleep {
	public static void main(String[] args) {
		Some some=new Some();
		some.start();
		try {
			some.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		some.interrupt();
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		some.stop();
		System.out.println(Some.i+"add "+ some.y);
	}
}

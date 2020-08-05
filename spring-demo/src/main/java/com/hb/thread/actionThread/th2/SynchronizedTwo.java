package com.hb.thread.actionThread.th2;

/**
 * 测试当两个线程执行存在两个加锁的代码块时，是否得到的是对象的锁
 * @author uname
 *
 */
public class SynchronizedTwo {
	static boolean b;
	public static void main(String[] args) {
//		Thread thread = new Thread(new ThreadA());
//		Thread thread2 = new Thread(new ThreadB());
//		thread.start();
//		thread2.start();
		System.out.println(b);
	}
}

class Runn{
	public void show(int i){
		synchronized(Runn.class){
			if(i==1){
				System.out.println("syn1");
			}
			try {
				Thread.sleep(3000);
				Thread.yield();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized(Runn.class){
			if(i==2){
				System.out.print("syn2");
			}
		}
	}
}

class ThreadA implements Runnable{
	private Runn run;
	@Override
	public void run() {
		run = new Runn();
		run.show(1);
		// TODO Auto-generated method stub
		
	}
	
}
class ThreadB implements Runnable{
	private Runn run;
	@Override
	public void run() {
		run = new Runn();
		run.show(2);
		// TODO Auto-generated method stub
		
	}
	
}

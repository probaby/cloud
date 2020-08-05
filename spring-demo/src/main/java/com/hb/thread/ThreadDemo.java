package com.hb.thread;

public class ThreadDemo {
	
	public static long t = 0;
	
	static class ChangeT implements Runnable {
		long t0 = 0;
		public ChangeT(long t) {
			this.t0 = t;
		}
		
		public void run() {
			ThreadDemo.t = t0;
		}
	}
	
	static class ReadT implements Runnable {
		long t1 = ThreadDemo.t;
		public void run() {
			while(true) {
				if(t1 != 111l && t1 != 222l && t1 != 333l && t1 != 444l) {
					System.out.println(t1);
				}
				//System.out.println(System.currentTimeMillis());
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new ChangeT(111l)).start();
		new Thread(new ChangeT(222l)).start();
		new Thread(new ChangeT(333l)).start();
		new Thread(new ChangeT(444l)).start();
		new Thread(new ReadT()).start();
		
	}

}

package com.hb.thread;

public class StopThread {
	class Stop implements Runnable {
		private boolean stopState = false;
		public void setState(boolean state) {
			stopState = state;
		}
		
		public void run (){
			while(true) {
				if(stopState) {
					System.out.println("end of thread");
					break;
				}
				
			}
		}
	}
}

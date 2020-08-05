package com.hb.jvm;

import java.io.Serializable;


 public class FinalizeShow implements Serializable{
	 final Object finalThing = new Object(){
		 @Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			//super.finalize();
			System.out.println("a finalThing finalize");
		}
	 };
	 @Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		//super.finalize();
		System.out.println("a finalize");
	}
	 
	public static void main(String[] args) {
		TTestB b = new TTestB();
		b = null;
		System.gc();
		//输出：
		//a finalThing finalize
		//b finalize
	}
}
class TTestB extends FinalizeShow{
	@Override protected void finalize() throws Throwable {
		//super.finalize();
		System.out.println("b finalize");
	}
}





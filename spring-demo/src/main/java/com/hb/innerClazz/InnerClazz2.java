package com.hb.innerClazz;

import java.io.FileInputStream;

interface Anonymous{
	
	public void showMethod();
	
}

public class InnerClazz2 {
	
	public Anonymous returnAn = new Anonymous(){
		public void showMethod2(int x){
			
			
			
			System.out.println("some thing have break");
		}

		public void showMethod() {
			// TODO Auto-generated method stub
			
		}
	};
	public static void main(String[] args) {
		new InnerClazz2().returnAn.showMethod();
	}
}

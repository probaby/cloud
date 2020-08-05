package com.hb.innerClazz;

public class InnerClazz {
	class Inner{
		
	} 
	public Inner returnInner(){
		return new Inner();
	}
	public static void main(String[] args) {
		Inner in = new InnerClazz().returnInner();
	}
}

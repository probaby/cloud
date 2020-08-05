package com.hb.innerClazz;


class Outer{
	
	public Inner getInner(){
		return new Inner();
	}
	
	class Inner{
		public Inner(){
			System.out.println("Inner open");
		}
	}
} 

public class InnerClazzCreate {
	public static void main(String[] args) {
		Outer.Inner inner = new Outer().new Inner();
	}
}

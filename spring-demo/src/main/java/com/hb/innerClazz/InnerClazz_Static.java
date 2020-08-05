package com.hb.innerClazz;

public class InnerClazz_Static {
	private int i=0;
	static class Some{
		//不能访问i
	} 
	public void some(){
		Some s = new Some();
	}
	class A{
		class B{
			
		}
	}
	public void show(){
		//多层嵌套内部类
		InnerClazz_Static.A.B b =new InnerClazz_Static().new A().new B();
	}
}

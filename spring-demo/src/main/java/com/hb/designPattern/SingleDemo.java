package com.hb.designPattern;

public class SingleDemo {
	
}

//饿汉
class SingleH{
	private final static SingleH  singleH= new SingleH();
	private SingleH(){
		
	}
	public static SingleH getSingleH(){
		if(singleH == null){
			return new SingleH();
		}
		return singleH;
	}
}

class SingleDoubleCheck{
	private static SingleDoubleCheck  singleDoubleCheck;
	private SingleDoubleCheck(){
		
	}
	public static SingleDoubleCheck getSingleH(){
		if(singleDoubleCheck == null){
			synchronized(SingleDoubleCheck.class){
				if(singleDoubleCheck == null){
					return new SingleDoubleCheck();
				}
			}
			
		}
		return singleDoubleCheck;
	}
}

//静态内部类
class StaticInnerClass{
	private StaticInnerClass(){};
	public StaticInnerClass getStaticInnerClass(){
		return InnerClass.staticInnerClass;
	}
	static class InnerClass{
		static StaticInnerClass staticInnerClass = new StaticInnerClass();
	}
}

//枚举
enum EnumDemo{
	INSTANCE;
	public void show(){
		
	}
}



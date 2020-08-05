package com.hb.innerClazz;

interface Wrap2{

}

abstract class Wrap{
	public Wrap(int x){
		
	}
}
public class InnerClazz_NoName {
	int a=1;
	public Wrap returnWrap(final int x){
		return new Wrap(x){
			public void showSomeThing(){
				a = a+x;
			}
		};//标记结束
	}
	public Wrap2 returnWrap2(){
		return new Wrap2(){
			
		};
	};
}

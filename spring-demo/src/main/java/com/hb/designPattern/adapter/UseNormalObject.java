package com.hb.designPattern.adapter;

public class UseNormalObject {
	NormalObject normalObject;
	public void setNormalObject(NormalObject normalObject){
		normalObject = normalObject;
	}
	
	public void show(){
		normalObject.show();
	}
}

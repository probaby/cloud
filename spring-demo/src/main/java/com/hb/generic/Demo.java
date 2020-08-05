package com.hb.generic;

public class Demo<T>{
	public Demo(T t){
		
	}
	public <E,V> V getThing(V... v){
		
		for (V v1 :v){
			return v1;
		}
		return null;
	}
}

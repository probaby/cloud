package com.hb.collection;

import java.util.ArrayList;
import java.util.Collection;

interface Selector{
	boolean end();
	Object select();
	void next();
}

public class Conllection_Sequance<T> {
	public Collection<T> object;
	int values = 0;
	
	public Conllection_Sequance(){
		object = new ArrayList<T>();
	}
	
	public void add(T t){
		object.add(t);
	}
	
	class Select implements Selector{
		
		int size=0;
		
		public Conllection_Sequance getInnerSe(){
			return Conllection_Sequance.this;
		}
		
		public boolean end() {
			
			return size == object.size();
		}

		public Object select() {
			
			return ((ArrayList<T>) object).get(size);
		}

		public void next() {
			
			if(size < object.size()){
				size++;
			}
		}
	}
	
	public static void main(String[] args) {
		Conllection_Sequance<Integer> in = new Conllection_Sequance<Integer>();
		in.add(1);
		in.add(2);
		in.add(3);
		in.add(4);
		in.add(5);
		Selector se = in.new Select();
		while( !se.end() ){
			System.out.println(se.select());
			se.next();
		}
	}
}


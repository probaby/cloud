package com.hb.innerClazz;




interface Selector{
	boolean end();
	Object select();
	void next();
}

public class InnerClazz_Sequence {
	public Object[] object;
	int values = 0;
	
	public InnerClazz_Sequence(int size){
		object = new Object[size];
	}
	
	public void add(Object obj){
		if(values<object.length){
			object[values++]=obj;
		}
	}
	
	class Select implements Selector{
		
		int size=0;
		
		public InnerClazz_Sequence getInnerSe(){
			return InnerClazz_Sequence.this;
		}
		
		public boolean end() {
			
			return size == object.length;
		}

		public Object select() {
			
			return object[size];
		}

		public void next() {
			
			if(size < object.length){
				size++;
			}
		}
	}
	
	public static void main(String[] args) {
		InnerClazz_Sequence in = new InnerClazz_Sequence(5);
		in.add(1);
		in.add(1);
		in.add(1);
		in.add(1);
		in.add(1);
		Select se = in.new Select();
		while( !se.end() ){
			System.out.println(se.select());
			se.next();
		}
	}
}

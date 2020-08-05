package com.hb.innerClazz;

public class InnerClazz_Private {
	private String t="1";
	private void show2(){
		System.out.println(t);
	}
	
	class InnerClazz{
		
		private String label = "some";
		
		public void changeT(){
			t="2";
			show2();
		}
	}
	
	public void show(){
		String a = new InnerClazz().label;
		 new InnerClazz().changeT();
		 System.out.println(t);
	}
	public static void main(String[] args) {
		new InnerClazz_Private().show();
	}
}

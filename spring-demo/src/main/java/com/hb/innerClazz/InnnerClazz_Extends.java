package com.hb.innerClazz;


class Some{
	SomeThing so;
	class SomeThing{
		public void say(){
			System.out.println("say");
		}
	}
	public void setSo(SomeThing st){
		so = st;
	}
}

public class InnnerClazz_Extends extends Some{
	class Ok extends Some.SomeThing{
		public Ok(Some s){
			s.super();
		}
		
		public void say(){
			System.out.println("sys extends");
		}
		
	}
	public static void main(String[] args) {
		Some s = new Some();
		InnnerClazz_Extends.Ok o = new InnnerClazz_Extends().new Ok(s); 
		s.setSo(o);
	}
}

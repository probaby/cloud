package com.hb.innerClazz;
interface Soa{
	
	Soa show();
}
public class InnerClazz_Scope {
	class Show implements Soa{
		public Soa show(){
			return new Show();
		}
	}
	
	
	public void showSome(){ 
		if(true){
			class DemoOne{
				String temp = "1";
			}
		}
	}
	
	
	public SomeTry getInnerClazz_private(){
		return new InnerClazz_private(); 
	}
	
	private class InnerClazz_private implements SomeTry{
		public void some() {
			// TODO Auto-generated method stub
			
		}		
	}
	public static void main(String[] args) {
		SomeTry so = new InnerClazz_Scope().getInnerClazz_private();
		InnerClazz_private some = (InnerClazz_private) so;
	}
	
	
	
}

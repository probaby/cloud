package com.hb.annotation;
@Test(id = 1, name = {"class1","class2"})
public class AnnotationDemo {
	@Test(id = 2, name = {"inti","int2"})
	public int i;
	@Test(id = 3, name = {"con","construction"})
	public AnnotationDemo(){
		
	}
	@Test(id = 4, name = {"method","method2"})
	public void show(){
		//@Test
		int i;
	}
	
	public void showCon(int a){
		
	}
}


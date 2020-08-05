package com.hb.designPattern.head_first;
/**
 * duck
 * @author uname
 *
 */
public class First_Duck {
	Fly flyThing;
	Quack quackThing;
	
	public void performQuack(){
		//flyThing.flyThing();
		String s="a aa  sa ";
		System.out.println(s.trim());;
	}
	public void performFly(){
		quackThing.quackThing();
	}
	public static void main(String[] args) {
		new First_Duck().performQuack();
	}
}

//两个接口：
interface Fly{
	void flyThing(); 
}

//
interface Quack{
	void quackThing();
}

//两个类分别实现

class FlyNoFly implements Fly{
	public void flyThing() {

	}
}

class QuackNoVoice implements Quack{
	public void quackThing(){
		
	}
	
}
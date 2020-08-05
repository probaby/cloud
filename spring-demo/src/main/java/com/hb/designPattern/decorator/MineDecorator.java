package com.hb.designPattern.decorator;


interface SubDecorator{
	public void discript();
	public int cost();
}

class SubDecoratorImp_1 implements SubDecorator{
	public SubDecorator sd;
	public SubDecoratorImp_1(SubDecorator sb){
		sd = sb;
	}

	public void discript() {
		// TODO Auto-generated method stub
		System.out.println("some thing broking 2");
		sd.discript();
	}

	public int cost() {
		// TODO Auto-generated method stub
		return sd.cost()+2;
	}
}


class BeDecoratorImp_1 implements SubDecorator{
	public int cost() {
		// TODO Auto-generated method stub
		return 1;
	}
	public void discript() {
		// TODO Auto-generated method stub
		System.out.println("some thing have break");
	}
}

public class MineDecorator {
	public static void main(String[] args) {
		SubDecorator bd=new BeDecoratorImp_1();
		bd = new SubDecoratorImp_1(bd);
		bd.discript();
		System.out.println(bd.cost());
	}
}

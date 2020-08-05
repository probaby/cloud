package com.hb.designPattern.factory.abstrat;

public class PizzaFactoryExtendedB implements PizzaFactory{

	@Override
	public TypeA creatTypeA() {
		// TODO Auto-generated method stub
		return new TypeAExtendedB();
	}

	@Override
	public TypeB creatTypeB() {
		// TODO Auto-generated method stub
		return new TypeBExtendedB();
	}

}

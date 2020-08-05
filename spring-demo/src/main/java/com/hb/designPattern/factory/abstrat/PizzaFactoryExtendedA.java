package com.hb.designPattern.factory.abstrat;

public class PizzaFactoryExtendedA implements PizzaFactory{

	@Override
	public TypeA creatTypeA() {
		// TODO Auto-generated method stub
		return new TypeAExtendedA();
	}

	@Override
	public TypeB creatTypeB() {
		// TODO Auto-generated method stub
		return new TypeBExtendedA();
	}

}

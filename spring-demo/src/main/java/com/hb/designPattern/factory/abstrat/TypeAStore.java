package com.hb.designPattern.factory.abstrat;

public class TypeAStore {
	public PizzaFactory pizzaFactory ;
	
	public TypeAStore(){
		pizzaFactory = new PizzaFactoryExtendedA();
	}
	
	public void makePizza(){
		TypeA typeA = pizzaFactory.creatTypeA();
		TypeB typeB = pizzaFactory.creatTypeB();
		System.out.println(typeA.type());
		System.out.println(typeB.type());
	}
}

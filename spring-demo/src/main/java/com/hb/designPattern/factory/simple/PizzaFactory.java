package com.hb.designPattern.factory.simple;

public class PizzaFactory {
	public Pizza makePizza(String type){
		if(("PizzaTypeA").equals(type)){
			return new PizzaTypeA();
		}else if("PizzaTypeb".equals(type)){
			return new PizzaTypeA();
		}else{
			throw new UnsupportedOperationException();
		}
	}
}

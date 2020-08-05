package com.hb.designPattern.factory.method;

public class PizzaStoreA implements PizzaStore{

	@Override
	public Pizza orderPizza(String type) {
		// TODO Auto-generated method stub
		if("PizzaTypeAA".equals(type)){
			return new PizzaTypeAA();
		}else if("PizzaTypeAB".equals(type)){
			return new PizzaTypeAB();
		}else{
			throw new UnsupportedOperationException();
		}
	}
	
}

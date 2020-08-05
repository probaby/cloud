package com.hb.designPattern.factory.method;

public class PizzaStoreB implements PizzaStore{

	@Override
	public Pizza orderPizza(String type) {
		// TODO Auto-generated method stub
		if("PizzaTypeBA".equals(type)){
			return new PizzaTypeBA();
		}else if("PizzaTypeBB".equals(type)){
			return new PizzaTypeBB();
		}else{
			throw new UnsupportedOperationException();
		}
	}
	
}

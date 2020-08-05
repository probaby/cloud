package com.hb.designPattern.factory.simple;

/*
 * 简单工厂
 * 1 在工厂中增加类别时不方便
 * 2 增加工厂时不方便
 */
public class PizzaTest {
	public static void main(String[] args) {
		PizzaFactory pizzaFactory = new  PizzaFactory();
		Pizza pizza = pizzaFactory.makePizza("PizzaTypeA");
		pizza.make();
	}
}

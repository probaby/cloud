package com.hb.designPattern.factory.method;

/**
 * 工厂方法
 * 将pizza和工厂 分开，实现动态创建工厂，用到哪个工厂就创建哪个工厂 
 * 但是未实现在工厂中 动态创建Pizza
 * 用户需要创建不同的pizza
 * @author uname
 *
 */

public class PizzaTest {
	public static void main(String[] args) {
		PizzaStore pizzaStore = new PizzaStoreA();
		Pizza pizza = pizzaStore.orderPizza("PizzaTypeAA");
		pizza.make();
	}
}

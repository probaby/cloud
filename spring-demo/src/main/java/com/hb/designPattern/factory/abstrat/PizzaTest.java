package com.hb.designPattern.factory.abstrat;



/**
 * 抽象工厂模式，实现依赖倒置，将上层对下层的 依赖解耦，不用在工厂中创建对象
 * 根据需要创建不同的工厂
 * 将type属性提取出来
 * @author uname
 *
 */
public class PizzaTest {
	public static void main(String[] args) {
		TypeAStore typeAStore = new TypeAStore();
		typeAStore.makePizza();
	}
}

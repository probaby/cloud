package com.hb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao deo=(Dao)ctx.getBean("dao");
		deo.excuteService();
	}
}

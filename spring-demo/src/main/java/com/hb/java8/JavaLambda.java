package com.hb.java8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


public class JavaLambda {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1aa","2bb","3cc","4dd");
		show(list,(e)->{
			if(e.equals("1aa")) {
				System.out.println("true");
				return true;
			}
			System.out.println("false");
			return false;
		});
	}

	public static void show (List<String> list,Predicate predicate) {
		for (String  s : list) {
			if(predicate.test(s)) {
				System.out.println(s);
			}
		}
	}
}

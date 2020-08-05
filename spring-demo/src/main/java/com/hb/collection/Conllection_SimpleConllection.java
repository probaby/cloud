package com.hb.collection;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Conllection_SimpleConllection {
	
	public static void main(String[] args) {
		Collection<Integer> con = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			con.add(i);
		}
		
		for (Integer integer : con) {
			System.out.println(integer);
		}
		
	}
}

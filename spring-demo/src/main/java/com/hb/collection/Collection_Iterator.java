package com.hb.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Go{
	public String name;
	public Go(String named){
		name = named;
	}
	@Override
	public String toString() {
		super.toString();
		return name;
	}
}

public class Collection_Iterator {
	public static void main(String[] args) {
		List<Go> list = new ArrayList<Go>(Arrays.asList(new Go("1"),new Go("11"),new Go("12")));
		System.out.println(list.contains(new Go("1")));
		Iterator<Go> it = list.iterator();
		Go g = new Go("2");
		if(it.hasNext()){
			g = it.next();
			System.out.println(g);
			System.out.println(it);
		}
		if(it.hasNext()){
				System.out.println(g);
				System.out.println(it);
				g = it.next();
				System.out.println(g);
				System.out.println(it);
			
		}
	
}
}

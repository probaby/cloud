package com.hb.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Demo{
}
class DemoNodeOne extends Demo{}

class DemoNodeTow extends Demo{}
class DemoNodeThree extends Demo{}

public class Conllection_Add {
	public static void main(String[] args) {
		
		
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3));
		collection.addAll(Arrays.asList(new Integer[]{1,2,3}));
		System.out.println("collection.addAll : "+collection);
		
		Collections.addAll(collection,1,2,3);
		System.out.println("Collections.addAll : " + collection);
		
		Collections.addAll(collection,new Integer[]{1,2,3});
		System.out.println("Collections.addAll : " + collection);
		
		List<Demo> col = Arrays.asList(new DemoNodeThree(),new DemoNodeOne(),new DemoNodeTow()); 
		//error 
		List<Demo> col2 = Arrays.asList(new DemoNodeOne(),new DemoNodeTow()); 
		Collection<Demo> col3 = new ArrayList<Demo>();
		Collections.addAll(col3, new DemoNodeOne(),new DemoNodeTow());
		System.out.println(col2);
		
		Collections.addAll(collection,new Integer[]{1,2,3});
		
		
	}
}

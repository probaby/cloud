package com.hb.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Collection_List {
	//
	public static void main(String[] args) {
		List<Integer> list =new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		System.out.println("list : " + list);
		Integer i = new Integer(8);
		list.add(i);
		System.out.println("list.add:"+list);
		System.out.println(list.contains(new Integer(8)));
		System.out.println("list.contains:"+list.contains(i));
		list.remove(i);
		System.out.println("list.remove:"+list);
		Integer j =list.get(2);
		System.out.println("list.indexOf:"+list.indexOf(j));
		list.add(1,new Integer(10));
		System.out.println("list.add(1,new Integer(10)):"+list);
		List<Integer> list2 = list.subList(1,3);
		System.out.println("list.sublist: "+list);
		System.out.println("list2:" +list2);
		System.out.println("list.containAll:"+list.containsAll(list2));
		
		Collections.sort(list2); 
		System.out.println("Collections.sort:"+list2);
		
		Collections.shuffle(list2);
		System.out.println("Collectyions.shuffle:"+list2);
		
		List<Integer> list3 = new ArrayList<Integer>(list);
		System.out.println("new ArrayList<Integer>(list):"+list3);
		
		list3.clear();
		System.out.println("list3.clear():"+list3);
		System.out.println("list3.isEmpty():"+list3.isEmpty());
		Object o[] = list.toArray();
		System.out.println("list.toArray:"+o);
		
/*		输出结果
		list : [1, 2, 3, 4, 5, 6, 7]
		list.add:[1, 2, 3, 4, 5, 6, 7, 8]
		true
		list.contains:true
		list.remove:[1, 2, 3, 4, 5, 6, 7]
		list.indexOf:2
		list.add(1,new Integer(10)):[1, 10, 2, 3, 4, 5, 6, 7]
		list.sublist: [1, 10, 2, 3, 4, 5, 6, 7]
		list2:[10, 2]
		list.containAll:true
		Collections.sort:[2, 10]
		Collectyions.shuffle:[2, 10]
		new ArrayList<Integer>(list):[1, 2, 10, 3, 4, 5, 6, 7]
		list3.clear():[]
		list3.isEmpty():true
		list.toArray:[Ljava.lang.Object;@22dd0f87
*/
	}
}

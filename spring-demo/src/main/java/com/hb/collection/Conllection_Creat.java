package com.hb.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

class CreateName{
	static int i = 0;
	static int j = 1;
	public static String next(){

		String s = "huangbiaoshuanghexiang";
		
		return  s.charAt(i)+""+s.charAt(j)+"";
		
	}
}

public class Conllection_Creat<T> {
	public static void main(String[] args) {
		Collection<String> col1 = new ArrayList<String>();
		Collection<String> col2 = new LinkedList<String>();
		//无顺序
		Collection<String> col3 = new HashSet<String>(); 
		//按照添加顺序
		Collection<String> col4 = new LinkedHashSet<String>();
		//按照升序
		Collection<String> col5 = new TreeSet<String>();
		for(int k = 0;k<5;k++){
			col1 .add(CreateName.next());
			col2 .add(CreateName.next());
			col3 .add(CreateName.next());
			col4 .add(CreateName.next());
			col5 .add(CreateName.next());
			CreateName.i++;
			CreateName.j++;
		}

			System.out.println("ArrayList : "+col1);
			System.out.println("LinkedList : "+col2);
			System.out.println("HashSet : "+col3);
			System.out.println("LinkedHashSet : "+col4);
			System.out.println("TreeSet : "+col5);
		
	}
}

package com.hb.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public void Test(){
		String s = "123-456-7890";
		char[] ch = s.toCharArray();
		String con = "";
		List<String> list = new ArrayList<String>();
		StringBuilder finalString = new StringBuilder();
		for (int i = ch.length-1;i>=0 ; i--) {
			if(ch[i]=='-'||(i==0||ch[i]!='-'?(con += String.valueOf(ch[i])).equals(con)&&(ch[i]=='-'||i==0):false)){
				list.add(con);
				con = "";
			}
		}
		for (int i = list.size()-1; i >= 0; i--) {
			finalString.append(list.get(i));
			if(i!=0)
				finalString.append("-");
		}
		System.out.println(finalString);
	}
}

package com.hb.collection;

import java.util.ArrayList;

class Gerbil{
	int jump;
	public Gerbil(){
		jump = 0;
	}
	public void hop(){
		System.out.println(jump);
	}
}

public class Conllection_First {
	public static void main(String[] args) {
		ArrayList<Gerbil> arrayList = new ArrayList<Gerbil>();
		for (int i = 0; i < 5; i++) {
			arrayList.add(new Gerbil());
		}
		for(Gerbil g:arrayList){
			g.hop();
		}
	}
}

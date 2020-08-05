package com.hb.designPattern.head_first;

import java.util.Observable;
import java.util.Observer;

enum show {

	  SUNNY, RAINY, WINDY, COLD;

	  @Override
	  public String toString() {
		  
		  System.out.println(this.ordinal());
	    return this.name().toLowerCase();
	  }
}
public class WeatherType{
	public static void main(String[] args) {
		System.out.println(show.COLD);
	}
}
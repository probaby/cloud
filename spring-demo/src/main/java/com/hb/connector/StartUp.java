package com.hb.connector;

public class StartUp {
	
	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector ();
		connector.start();
	}
}

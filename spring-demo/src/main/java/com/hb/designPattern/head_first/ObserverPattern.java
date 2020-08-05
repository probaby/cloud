package com.hb.designPattern.head_first;

import java.util.ArrayList;

interface Theme{
	void registerObserver(Observer ob);
	void removeObserver(Observer ob);
	void notifiyObserver();
}

class ThemeImp implements Theme{

	ArrayList<Observer> oblist;
	Object obj;
	boolean changed = false;
	
	public ThemeImp(){
		oblist = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer ob) {
		oblist.add(ob);
		
	}

	public void removeObserver(Observer ob) {
		oblist.remove(oblist.indexOf(ob));
		
	}

	public void notifiyObserver() {
		if(changed){
			for (Observer observer : oblist) {
				observer.update(obj);
			}
		}
		changed = false;
	}
	
	
	public void setObj(Object obj){
		this.obj = obj;
		changed = true; 
	}
}

interface Observer{
	void update(Object obj);
	void display();
}

class ObserverImp_1 implements Observer{
	Object obj;
	public ObserverImp_1(){
		obj = new Object();
	}
	
	public void update(Object obj) {
		obj = obj;
	}

	public void display() {
		
	}
	
}

class ObserverImp_2 implements Observer{
	Object obj;
	public ObserverImp_2(){
		obj = new Object();
	}
	
	public void update(Object obj) {
		obj = obj;
	}

	public void display() {
		
	}
	
}

public class ObserverPattern {
	public static void main(String[] args) {
		
		Theme themeImp = new ThemeImp();
		themeImp.registerObserver(new ObserverImp_1());
		themeImp.registerObserver(new ObserverImp_2());

	}
}

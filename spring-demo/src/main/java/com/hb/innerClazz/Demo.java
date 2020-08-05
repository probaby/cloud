package com.hb.innerClazz;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;






public abstract class Demo<S extends Demo, O extends Demo, A> {

	  protected List<O> observers;

	  public Demo() {
	    this.observers = new CopyOnWriteArrayList<O>();
	  }

	  public void addObserver(O observer) {
	    this.observers.add(observer);
	  }

	  public void removeObserver(O observer) {
	    this.observers.remove(observer);
	  }

	  /**
	   * Notify observers
	   */
	  @SuppressWarnings("unchecked")
	  public void notifyObservers(A argument) {
	    for (O observer : observers) {
	      
	    }
	  }
	}
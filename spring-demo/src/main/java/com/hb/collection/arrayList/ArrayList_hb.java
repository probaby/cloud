package com.hb.collection.arrayList;


import com.hb.annotation.Test;

import java.util.*;

/**
 * arraylist重要方法重新写一遍
 * @author uname
 *
 */
public class ArrayList_hb<E> implements List<E> {
	int size;
	Object[] objectEmpty = {};
	Object[] objectData;
	int modCount;
	/**
	 * @throws Exception 
	 * @throws IllegalArgumentException if the specified initial capacity
	 *         is negative
	 * 
	 */
	public ArrayList_hb(int initCapacity) throws Exception {
		if(initCapacity>=0){ 
			objectData = new Object[initCapacity];
			size = initCapacity;
		}else {
			throw new Exception("initCapacity is not formate");
		}
	}
	
	public ArrayList_hb(){
		objectData = objectEmpty;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		
		for(int i = 0;i<size;i++){
			if(objectData[i].equals(o)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
//		return new Itr();
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private class Itr implements Iterator<E>{
//		int cursor;
//		int lastRet =  -1;
//		int expectedModCount = modCount;
//		@Override
//		public boolean hasNext() {
//			// TODO Auto-generated method stub
//			return cursor !=size;
//		}
//		@Override
//		public E next() {
//			// TODO Auto-generated method stub
//			checkForComodification();
//			int i = cursor ;
//			if(i>size)
//				throw new NoSuchElementException();
//			Object[] elementData = ArrayList_hb.this.objectData;
//			if(i>=elementData.length)
//				throw new ConcurrentModificationException();
//			cursor = i + 1;
//			return (E)elementData[lastRet = i];
//		}
//
//		void checkForComodification(){
//			if(modCount != expectedModCount)
//				throw new ConcurrentModificationException();
//		}
//
//	}
	
	static final  String[] s = {"ss","sss","ssss"};
	@Test
	public static void test(){
		ArrayList<String> list = new ArrayList(10);
		s[0] = "bb";
		String[] s1 = s;
		s1[1] = "aa";
		System.out.println(s[1]+"  "+s[0]);
		//System.out.println(list.size());
	}
	
	public static void main(String[] args) {
		test();
	}
}
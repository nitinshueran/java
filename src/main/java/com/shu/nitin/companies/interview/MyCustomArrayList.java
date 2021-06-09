package com.shu.nitin.companies.interview;

import java.util.Arrays;
import java.util.Iterator;

public class MyCustomArrayList<E> {

	/**
	 * Default initial capacity.
	 */
	private static final int DEFAULT_CAPACITY = 10;

	private Object[] internalArray;

	public MyCustomArrayList() {
		internalArray = new Object[DEFAULT_CAPACITY];
	}

	public int size() {
		return internalArray.length;
	}

	public boolean contains(Object o) {
		Arrays.binarySearch(internalArray, o);
		return false;
	}

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}

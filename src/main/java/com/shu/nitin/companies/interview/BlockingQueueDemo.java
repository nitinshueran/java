package com.shu.nitin.companies.interview;

import java.util.HashSet;
import java.util.Set;

public class BlockingQueueDemo extends Test05_B {

	private int id;
	private String value;

	public BlockingQueueDemo(int id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public static void main(String[] args) {
		BlockingQueueDemo bd = new BlockingQueueDemo(1, "One");
		BlockingQueueDemo bd2 = new BlockingQueueDemo(1, "One");
		Set<BlockingQueueDemo> bdbd = new HashSet<>();
		bdbd.add(bd);
		bdbd.add(bd2);
		System.out.println(bdbd.size());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

}

class Test05_B extends Test05_A {

	public void display() {
		System.out.println("Class B");
	}

}

class Test05_A {
	public void display() {
		System.out.println("Class A");
	}
}

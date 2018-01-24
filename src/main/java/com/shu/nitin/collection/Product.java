package com.shu.nitin.collection;

import java.util.StringJoiner;

public class Product {
	
	private String name;
	private int weight;
	
	public Product(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public String toString() {
		StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
		stringJoiner.add(this.getName());
		stringJoiner.add(Integer.toString(this.getWeight()));
		return stringJoiner.toString();
	}
	
	

}

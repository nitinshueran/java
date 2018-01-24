package com.shu.nitin.java8.StringJoiner;

import java.util.StringJoiner;

public class StringJoinerDemo {

	public static void main(String[] args) {
		StringJoiner sj1 = new StringJoiner(", ");
		sj1.add("Nitin");
		sj1.add("Akshita");
		sj1.add("Nitu");
		System.out.println(sj1.toString());
		
		StringJoiner sj2 = new StringJoiner(", ", "{", "}");
		sj2.add("Sonu").add("Nikki").add("Nitu");
		System.out.println(sj2.toString());
	}

}

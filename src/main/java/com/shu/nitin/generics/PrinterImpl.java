package com.shu.nitin.generics;

import com.shu.nitin.java8.lambda.e1.Person;

public class PrinterImpl<T> implements Printer<T> {

	@Override
	public void print(T t) {
		System.out.println(t.toString());
	}
	
	public static void main(String[] args) {
		
		Printer<String> printer = new PrinterImpl<>();
		printer.print("Nitin");
		
		Person person = new Person("Nitin", "Shueran", 23);
		Printer<Person> personPrinter = new PrinterImpl<>();
		personPrinter.print(person);
	}

}

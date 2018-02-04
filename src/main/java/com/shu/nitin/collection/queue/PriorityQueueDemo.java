package com.shu.nitin.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
	}
	
}

class Customer {
	
	private String name;

	public Customer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
class Enquiry{
	
	
	private Queue<Enquiry> enquiries = new PriorityQueue<>();
	
	public void enquire(Customer customer, Category category) {
		
	}
}
enum Category{
	
	PRINTER,
	
	PHONE,
	
	LAPTOP
}

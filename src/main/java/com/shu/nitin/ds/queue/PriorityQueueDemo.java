package com.shu.nitin.ds.queue;

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

class Enquiry {

	public void enquire(Customer customer, Category category) {

	}
}

enum Category {

	PRINTER,

	PHONE,

	LAPTOP
}

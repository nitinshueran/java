package com.shu.nitin.passbyvalue;

import com.shu.nitin.java8.lambda.e1.Person;

public class JavaIsPassByValueDemo {

	public static void main(String[] args) {
		JavaIsPassByValueDemo jipbv = new JavaIsPassByValueDemo();
		Person nitin = new Person("Nitin", "Shueran", 28);
		jipbv.updatePerson(nitin);
		System.out.println(nitin.toString());
		jipbv.updatePersonToNewPerson(nitin);
		System.out.println(nitin.toString());
	}
	
	private void updatePerson(Person p) {
		p.setfName("Nitesh");
		p.setlName("Sheoran");
		p.setAge(25);
	}
	
	private void updatePersonToNewPerson(Person p) {
		p = new Person("Akshita", "Shueran", 28);
	}
}



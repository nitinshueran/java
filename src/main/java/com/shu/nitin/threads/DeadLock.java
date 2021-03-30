package com.shu.nitin.threads;

public class DeadLock {
	private Person nitin = new Person("Nitin");
	private Person nitesh = new Person("Nitesh");

	public static void main(String[] args) {
		new DeadLock().deadlock();
	}

	private void deadlock() {
		Thread t1 = new Thread(() -> {
			int i=0;
			while (i < 100) {
				synchronized (nitin) {
					synchronized (nitesh) {
						System.out.println("Thread 1");
						i++;
					}
				}
			}
		});

		Thread t2 = new Thread(() -> {
			int i=0;
			while (i < 100) {
				synchronized (nitin) {
					synchronized (nitesh) {
						System.out.println("Thread 2");
						i++;
					}
				}
			}
			// System.out.println(i);
		});
		t1.start();
		t2.start();
	}

}

class Person {

	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

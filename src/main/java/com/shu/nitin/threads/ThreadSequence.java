package com.shu.nitin.threads;

public class ThreadSequence {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			System.out.println("Thread1");
		});
		Thread t2 = new Thread(() -> {
			System.out.println("Thread2");
		});
		Thread t3 = new Thread(() -> {
			System.out.println("Thread3");
		});

		t1.start();
		// t1.join();
		t2.start();
		// t2.join();
		t3.start();
		// t3.join();
	}

}

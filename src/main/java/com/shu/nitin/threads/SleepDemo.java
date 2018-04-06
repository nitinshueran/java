package com.shu.nitin.threads;

public class SleepDemo {

	public static void main(String[] args) {

		Runnable slideRotater = () -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Displaying content of Slide: " + i);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("I got interrupted");
			}
		};
		Thread t = new Thread(slideRotater);
		t.start();

		t.interrupt();
		System.out.println("End of main thread");
	}
}

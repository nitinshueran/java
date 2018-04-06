package com.shu.nitin.threads;

public class WaitNotifyDemo {

	public static void main(String[] args) {
		Incrementer incrementer = new Incrementer();
		Calculator calculator1 = new Calculator(incrementer);
		Calculator calculator2 = new Calculator(incrementer);
		Calculator calculator3 = new Calculator(incrementer);

		calculator1.start();
		calculator2.start();
		calculator3.start();

		incrementer.start();
	}

}

class Calculator extends Thread {

	private Incrementer incrementer;

	public Calculator(Incrementer incrementer) {
		super();
		this.incrementer = incrementer;
	}

	@Override
	public void run() {

		synchronized (incrementer) {
			try {
				incrementer.wait();
			} catch (InterruptedException e) {
				System.out.println("Total count is: " + incrementer.getTotal());
			}
		}

	}
}

class Incrementer extends Thread {

	private int total;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 1; i++) {
				total += i;
			}
			notifyAll();
		}

	}

	public int getTotal() {
		return total;
	}

}

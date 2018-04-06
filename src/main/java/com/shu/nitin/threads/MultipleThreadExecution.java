package com.shu.nitin.threads;

public class MultipleThreadExecution {
	public static void main(String[] args) {
		Thread t1 = new Thread(new FirstThread());
		Thread t2 = new Thread(new SecondThread());
		t1.start();
		t2.start();
	}
}

class FirstThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Running thread 1");
		try {
			System.out.println("Going to sleep");
			Thread.sleep(10000);
			System.out.println("Time to wake up");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class SecondThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Running thread 2");
	}
	
}

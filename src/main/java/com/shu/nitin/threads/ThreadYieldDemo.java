package com.shu.nitin.threads;

public class ThreadYieldDemo implements Runnable{
	
	public static void main(String[] args) throws InterruptedException {
		ThreadYieldDemo childThread = new ThreadYieldDemo();
		Thread t = new Thread(childThread);
		t.start();
		for(int i=0; i<10; i++) {
			System.out.println("Main Thread");
			Thread.sleep(1000);
		}
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Child thread");
			Thread.yield();
		}
	}
}

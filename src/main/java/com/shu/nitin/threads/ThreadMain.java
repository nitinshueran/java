package com.shu.nitin.threads;

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

public class ThreadMain {

	public static void main(String[] args) {
		System.out.println("Starting new thread to print 1 to 10");
		MyThread t1 = new MyThread();
		t1.start();
		System.out.println("Exiting from main thread.");
		
		MyRunnable runnable = new MyRunnable();
		Thread runnableThread = new Thread(runnable);
		runnableThread.start();
	}
}

package com.shu.nitin.threads;

public class DeadLockDemo {

	public static void main(String[] args) {
		String str1 = "Nitin";
		String str2 = "Nitesh";

		Thread t = new Thread() {

			@Override
			public void run() {
				while(true) {
					synchronized (str1) {
						synchronized (str2) {
							System.out.println(str1 + " "+str2);
						}
					}
				}
			}
		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				while(true) {
					synchronized (str2) {
						synchronized (str1) {
							System.out.println(str2 +" "+ str1);
						}
					}
				}
			}
		};
		
		t.start();
		t2.start();
	}

}

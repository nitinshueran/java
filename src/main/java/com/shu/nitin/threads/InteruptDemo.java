package com.shu.nitin.threads;

import java.io.IOException;

public class InteruptDemo {

	public static void main(String[] args) {
		Thread thread = new Thread(new WaitingForUserInput());
		thread.setName("InputWaitingThread");
		thread.start();
		Thread.currentThread().interrupt();
	}
}

class WaitingForUserInput implements Runnable {
	@Override
	public void run() {
		try {
			while (true) {

				char input = (char) System.in.read();
				if (input == 'q') {
					return;
				}
				if (Thread.currentThread().isInterrupted()) {
					return;
				}
			}
		} catch (IOException e) {
			System.out.println("An exception was caught " + e);
		}
		;
	}
}

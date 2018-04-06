package com.shu.nitin.threads;

public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread cardPrinting = new Thread(new CardPrinting());
		Thread venueFinalization = new Thread(new VenuFinalization());
		Thread cardDistribution = new Thread(new CardDistribution());
		
		venueFinalization.start();
		venueFinalization.join();
		
		cardPrinting.start();
		cardPrinting.join();
		
		cardDistribution.start();
	}

}

class VenuFinalization implements Runnable{

	@Override
	public void run() {
			try {
				System.out.println("Finding venue for Wedding");
				Thread.sleep(1000);
				System.out.println("Venue finalized");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
}

class CardPrinting implements Runnable{

	@Override
	public void run() {
			try {
				System.out.println("Printing cards for wedding");
				Thread.sleep(1200);
				System.out.println("Cards Printed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
}

class CardDistribution implements Runnable{

	@Override
	public void run() {
			try {
				System.out.println("Distributing cards for wedding");
				Thread.sleep(1500);
				System.out.println("Cards distributed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
}

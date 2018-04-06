package com.shu.nitin.threads;

public class ThreadJoinDemo2 {
	
	public static void main(String[] args) {
		
		Thread venueFinalization = new Thread(new VenuFinalization2());
		Thread cardPrinting = new Thread(new CardPrinting2(venueFinalization));
		Thread cardDistribution = new Thread(new CardDistribution2(cardPrinting));
		
		venueFinalization.start();
		cardPrinting.start();
		cardDistribution.start();
	}
	
}
class VenuFinalization2 implements Runnable{
	
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

class CardPrinting2 implements Runnable{
	
	public static Thread venueFinalizationThread;
	
	public CardPrinting2(Thread venueFinalizationThread) {
		CardPrinting2.venueFinalizationThread = venueFinalizationThread;
	}
	
	@Override
	public void run() {
			try {
				
				venueFinalizationThread.join();
				
				System.out.println("Printing cards for wedding");
				Thread.sleep(1200);
				System.out.println("Cards Printed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
}

class CardDistribution2 implements Runnable{

	static Thread cardPrintingThread;
	
	public CardDistribution2(Thread cardPrintingThread) {
		CardDistribution2.cardPrintingThread = cardPrintingThread;
	}
	
	@Override
	public void run() {
			try {
				
				cardPrintingThread.join();
				
				System.out.println("Distributing cards for wedding");
				Thread.sleep(1500);
				System.out.println("Cards distributed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
}
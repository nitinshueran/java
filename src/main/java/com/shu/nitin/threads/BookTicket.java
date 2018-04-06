package com.shu.nitin.threads;

public class BookTicket implements Runnable{
	
	private ReserveSeats reserveSeats;
	
	public BookTicket(ReserveSeats reserveSeats) {
		this.reserveSeats = reserveSeats;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to ticket booking system");
		ReserveSeats reserveSeats = new ReserveSeats();
		Runnable ticketBookingThread1 = new BookTicket(reserveSeats);
		Thread t1 = new Thread(ticketBookingThread1, "Nitin");
		Thread t2 = new Thread(ticketBookingThread1, "Nitesh");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		reserveSeats.checkAvailableTickets();
		reserveSeats.bookTicket();
	}
	
	
	
}

class ReserveSeats {

	public void checkAvailableTickets() {
		System.out.println("Seats available for "+ Thread.currentThread().getName());
	}
	
	public synchronized void bookTicket() {
		System.out.println("Booking seats for "+Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ticket Booked for "+Thread.currentThread().getName());
	}

}

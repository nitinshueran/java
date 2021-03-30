package com.shu.nitin.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class PhilEatSol {

	public static void main(String[] args) {

		Fork f1 = new Fork(1);
		Fork f2 = new Fork(2);
		Fork f3 = new Fork(3);
		Fork f4 = new Fork(4);
		Fork f5 = new Fork(5);

		Philishopher p1 = new Philishopher(1, f1, f2);
		Philishopher p2 = new Philishopher(2, f2, f3);
		Philishopher p3 = new Philishopher(3, f3, f4);
		Philishopher p4 = new Philishopher(4, f4, f5);
		Philishopher p5 = new Philishopher(5, f5, f1);

		Thread p1Eat = new Thread(() -> {
			while (true) {
				p1.eat();
			}
		}, "p1");

		Thread p2Eat = new Thread(() -> {
			while (true) {
				p2.eat();
			}
		}, "p2");

		Thread p3Eat = new Thread(() -> {
			while (true) {
				p3.eat();
			}
		}, "p3");

		Thread p4Eat = new Thread(() -> {
			while (true) {
				p4.eat();
			}
		}, "p4");

		Thread p5Eat = new Thread(() -> {
			while (true) {
				p5.eat();
			}
		}, "p5");

		p1Eat.start();
		p2Eat.start();
		p3Eat.start();
		p4Eat.start();
		p5Eat.start();

	}

}

class Philishopher {

	private int id;

	private Fork left;

	private Fork right;

	public Philishopher(int id, Fork left, Fork right) {
		super();
		this.id = id;
		this.left = left;
		this.right = right;
	}

	public void eat() {
		while (left.isTaken() && right.isTaken()) {
			try {
				left.getAvailable().await();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("p" + this.id + " has started eating");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

}

class Fork {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private ReadLock readLock = lock.readLock();
	private WriteLock writeLock = lock.writeLock();
	private Condition available = writeLock.newCondition();
	private Condition notAvialable = writeLock.newCondition();

	private int id;
	private boolean taken;

	public Fork(int id) {
		super();
		this.id = id;
		this.taken = false;
	}

	public int getId() {
		return id;
	}

	public boolean isTaken() {
		try {
			readLock.lock();
			return taken;
		} finally {
			readLock.unlock();
		}

	}

	public void setTaken(boolean taken) {

		try {
			writeLock.lock();
			this.taken = taken;
		} finally {
			writeLock.unlock();
		}
	}

	public ReadLock getReadLock() {
		return readLock;
	}

	public WriteLock getWriteLock() {
		return writeLock;
	}

	public Condition getAvailable() {
		return available;
	}

	public Condition getNotAvialable() {
		return notAvialable;
	}


}

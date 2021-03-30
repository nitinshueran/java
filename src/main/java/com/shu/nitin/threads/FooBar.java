package com.shu.nitin.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class FooBar {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private WriteLock writeLock = lock.writeLock();

	private Condition fooPrinted = writeLock.newCondition();
	private Condition barPrinted = writeLock.newCondition();

	private boolean isFooPrinted = false;
	private boolean isBarPrinted = true;

	private int n;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			try {
				writeLock.lock();
				while (!isBarPrinted) {
					barPrinted.await();
				}
				printFoo.run();
				isBarPrinted = false;
				fooPrinted.signalAll();
			} finally {
				writeLock.unlock();
			}

		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			try {
				writeLock.lock();
				while (!isFooPrinted) {
					fooPrinted.await();
				}
				printBar.run();
				isFooPrinted = false;
				barPrinted.signalAll();

			} finally {
				writeLock.unlock();
			}
			// printBar.run() outputs "bar". Do not change or remove this line.
		}
	}

	public static void main(String[] args) throws InterruptedException {
		FooBar obj = new FooBar(2);
		Runnable foo = () -> {
			System.out.print("foo");
		};
		Runnable bar = () -> {
			System.out.print("bar");
		};
		obj.foo(foo);
		obj.foo(bar);
	}

}

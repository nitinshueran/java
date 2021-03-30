package com.shu.nitin.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class BlockingQueue<E> {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private WriteLock writeLock = lock.writeLock();

	private Condition notEmpty = writeLock.newCondition();
	private Condition notFull = writeLock.newCondition();

	private Queue<E> queue;

	private int capacity;

	public BlockingQueue(int capacity) {
		super();
		this.queue = new LinkedList<>();
		this.capacity = capacity;
	}

	public void put(E element) {
		try {
			writeLock.lock();
			while (queue.size() == capacity) {
				try {
					System.out.println("Queue is full, awaiting consumer");
					notFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			queue.add(element);
			notEmpty.signalAll();
		} finally {
			writeLock.unlock();
		}

	}

	public E remove() {
		try {
			Thread.sleep(1000);
			writeLock.lock();
			while (queue.isEmpty()) {
				notEmpty.await();
			}
			E element = queue.remove();
			notFull.signalAll();
			return element;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
		return null;
		
	}

	public static void main(String[] args) {
		BlockingQueue<Integer> names = new BlockingQueue<>(16);
		Thread producer = new Thread(() -> {
			int count = 1;
			while (true) {
				System.out.println("Producing: " + count);
				names.put(count);
				count++;
			}
		});

		Thread consumer = new Thread(() -> {
			while (true) {
				System.out.println("Consumed: " + names.remove());
			}
		});

		producer.start();
		consumer.start();
	}

}

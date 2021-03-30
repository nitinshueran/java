package com.shu.nitin.zalando;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LiveCodingExercise {

	private static BlockingQUeue queue = new BlockingQUeue(16);

	public static void main(String[] args) {

		Thread producer = new Thread(() -> {
			int i = 1;
			while (true) {
				queue.put(i);
				System.out.println("Produced: " + i);
				i++;
			}
		});

		Thread consumer = new Thread(() -> {
			while (true) {
				System.out.println("Consumed" + queue.get());
			}
		});

		producer.start();
		consumer.start();

	}

}

class BlockingQUeue {

	private Queue<Integer> blockingQueue;
	private int size;

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private WriteLock writeLock = lock.writeLock();
	private Condition notEmpty = writeLock.newCondition();
	private Condition notFull = writeLock.newCondition();

	public BlockingQUeue(int size) {
		super();
		this.size = size;
		blockingQueue = new LinkedList<>();
	}

	public void put(Integer element) {
		try {
			writeLock.lock();
			while (blockingQueue.size() >= size) {
				try {
					System.out.println("Queue is full waiting for consumer");
					notFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			blockingQueue.add(element);
			notEmpty.signalAll();

		} finally {
			writeLock.unlock();
		}
	}

	public Integer get() {
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			writeLock.lock();
			while (blockingQueue.isEmpty()) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Integer element = blockingQueue.remove();
			notFull.signalAll();
			return element;

		} finally {
			writeLock.unlock();
		}

	}
}

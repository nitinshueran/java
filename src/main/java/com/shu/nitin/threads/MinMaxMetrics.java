package com.shu.nitin.threads;

import java.util.Random;

public class MinMaxMetrics {

	public static void main(String[] args) {

		Stock stock = new Stock(0, 10);
		MinMaxMetrics minMaxMetrics = new MinMaxMetrics(stock);
		Random random = new Random();

		Thread addSampleThread = new Thread(() -> {
			while (true) {
				minMaxMetrics.addSample(random.nextLong());
			}
		});

		Thread getMin = new Thread(() -> {
			while (true) {
				System.out.println("Min: " + minMaxMetrics.getMin());
			}
		});

		Thread getMax = new Thread(() -> {
			while (true) {
				System.out.println("Max: " + minMaxMetrics.getMin());
			}
		});

		addSampleThread.start();
		getMin.start();
		getMax.start();
	}

	// Add all necessary member variables
	private Stock stock;

	/**
	 * Initializes all member variables
	 */
	public MinMaxMetrics(Stock stock) {
		this.stock = stock;
	}

	/**
	 * Adds a new sample to our metrics.
	 */
	public void addSample(long newSample) {
		if (newSample < this.getMin()) {
			this.stock.setMin(newSample);
		} else if (newSample > this.getMax()) {
			this.stock.setMax(newSample);
		}
	}

	/**
	 * Returns the smallest sample we've seen so far.
	 */
	public long getMin() {
		return this.stock.getMin();
	}

	/**
	 * Returns the biggest sample we've seen so far.
	 */
	public long getMax() {
		// Add code here
		return this.stock.getMax();
	}

	static class Stock {
		private long min;
		private long max;

		public Stock(long min, long max) {
			this.min = min;
			this.max = max;
		}

		public long getMax() {
			return max;
		}

		public long getMin() {
			return min;
		}

		public void setMin(long min) {
			this.min = min;
		}

		public void setMax(long max) {
			this.max = max;
		}
	}
}

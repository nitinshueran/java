package com.shu.nitin.threads;

import java.math.BigInteger;

public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		ComplexCalculation cc = new ComplexCalculation();
		System.out.println(cc.calculateResult(new BigInteger("10000000"), new BigInteger("30000"),
				new BigInteger("1000000000000000000"),
				new BigInteger("300000")));
	}
}

class ComplexCalculation {

	public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2)
			throws InterruptedException {
		BigInteger result = BigInteger.ONE;
		PowerCalculatingThread t1 = new PowerCalculatingThread(base1, power1);
		PowerCalculatingThread t2 = new PowerCalculatingThread(base2, power2);
		t1.start();
		t2.start();
		/*
		 * Calculate result = ( base1 ^ power1 ) + (base2 ^ power2). Where each
		 * calculation in (..) is calculated on a different thread
		 */
		t1.join();
		t2.join();
		result = t1.getResult().add(t2.getResult());
		return result;
	}

	private static class PowerCalculatingThread extends Thread {
		private BigInteger result = BigInteger.ONE;
		private BigInteger base;
		private BigInteger power;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			int powerInt = this.power.intValue();
			for (int i = 0; i < powerInt; i++) {
				result = result.multiply(this.base);
			}
		}

		public BigInteger getResult() {
			return result;
		}
	}
}

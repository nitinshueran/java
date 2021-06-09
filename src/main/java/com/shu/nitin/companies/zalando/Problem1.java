package com.shu.nitin.companies.zalando;

public class Problem1 {

	public static void main(String[] args) {
		String numbers = "1010112";
		int max = findMax(numbers);
	}

	private static int findMax(String numbers) {
		char[] chars = numbers.toCharArray();
		int i = 1;
		int j = i + 1;
		int firstMax = Character.getNumericValue(chars[0]);
		int secondMax = Character.getNumericValue(chars[1]);
		while (i < chars.length && j < chars.length) {
			int first = Character.getNumericValue(chars[i]);
			if (first > firstMax) {
				firstMax = first;
				secondMax = Character.getNumericValue(chars[j]);
				i = i + 1;
			} else if (first == firstMax) {
				int second = Character.getNumericValue(chars[j]);
				if (second > secondMax) {
					secondMax = second;
				}
				i = i + 1;

			} else {
				i = j + 1;
			}

			j = i + 1;

		}
		return firstMax * 10 + secondMax;
	}

}

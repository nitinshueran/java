package com.shu.nitin.algo.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] elements = new int[] { 1, 2, 3, 4, 5 };
		int search = 6;
		int start = 0;
		int end = elements.length - 1;
		while (start <= end) {
			int index = (start + end) / 2;
			if (elements[index] == search) {
				System.out.println(index);
				break;
			} else if (elements[index] > search) {
				end = index - 1;

			} else {
				start = index + 1;
			}
		}

	}

}

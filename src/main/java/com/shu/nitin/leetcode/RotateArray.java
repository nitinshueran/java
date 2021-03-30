package com.shu.nitin.leetcode;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		long[] elements = new long[] { 0, 1, 1, 2, 3 };
		rotate(elements);
		Arrays.stream(elements).forEach(System.out::println);

	}

	public static void rotate(long arr[]) {
		int len = arr.length;
		long first = arr[len];

		for (int i = len - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = first;
	}

}

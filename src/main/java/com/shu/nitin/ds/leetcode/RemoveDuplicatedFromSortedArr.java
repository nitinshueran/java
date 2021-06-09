package com.shu.nitin.ds.leetcode;

import java.util.Arrays;

public class RemoveDuplicatedFromSortedArr {

	public static void main(String[] args) {
		int[] elements = new int[] { 0, 1, 1, 2, 3 };
		int max = removeDuplicates(elements);
		Arrays.stream(elements).limit(max).forEach(System.out::println);
	}

	private static int removeDuplicates(int[] nums) {
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				nums[i + 1] = nums[j];
				i++;
			}
		}
		return i + 1;
	}
}

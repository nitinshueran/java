package com.shu.nitin.companies.zalando;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int A[] = { 1, 1, 3, -1, -1 };
		System.out.println(new Solution().solution(A));

		int A2[] = { 1, 1, 3, 3, 3, 4, 5, 5, 5, 5 };
		int A3[] = { 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5 };
		System.out.println(new Solution().solution(A3, 15));
	}

	public int solution(int[] A) {

		if (A.length == 0 || Arrays.stream(A).anyMatch(elem -> elem == 0)) {
			return 0;
		}
		long lessThanZeroOccurances = Arrays.stream(A).filter(val -> val < 0).count();
		if (lessThanZeroOccurances > 0 && lessThanZeroOccurances % 2 != 0) {
			return -1;
		}
		return 1;

	}

	int solution(int[] A, int K) {
		int n = A.length;
		int best = 1;
		int count = 0;
		for (int i = 0; i < n - 1 - K; i++) {
			if (A[i] == A[i + 1])
				count = count + 1;
			else
				count = 0;
			if (count > best)
				best = count;
		}
		int result = n != 0 ? best + K + 1 : 0;
		return result > n ? n : result;
	}

}

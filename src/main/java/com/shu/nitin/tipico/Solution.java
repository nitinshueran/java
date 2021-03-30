package com.shu.nitin.tipico;

public class Solution {

	public static void main(String[] args) {

		int[] A1 = { 2, -2, -3, 3 };
		int[] B1 = { 0, 0, 4, -4 };
		System.out.println(new Solution().solution(A1, B1));

	}

	public int solution(int[] A, int[] B) {
		int fairIndexes = 0;
		if (A.length > 0 && B.length > 0) {
			int firstLeftSum = 0;
			for (int i = 0; i < A.length; i++) {
				firstLeftSum += A[i];
				int firstRightSum = 0;

				for (int j = i + 1; j < A.length; j++)
					firstRightSum += A[j];

				if (firstLeftSum == firstRightSum) {

					int secondLeftSum = 0;
					for (int k = 0; k <= i; k++) {
						secondLeftSum += B[k];
					}
					if (secondLeftSum == firstLeftSum) {
						int secondRightSum = 0;
						for (int l = i + 1; l < B.length; l++) {
							secondRightSum += B[l];
						}
						if (firstLeftSum == secondRightSum) {
							if (i + 1 < A.length) {
								fairIndexes += 1;
							}
						}
					}
				}

			}
		}
		return fairIndexes;
	}

	static int findSplitPoint(int arr[], int n) {

		int leftSum = 0;

		// traverse array element
		for (int i = 0; i < n; i++) {
			// add current element to left Sum
			leftSum += arr[i];

			// find sum of rest array
			// elements (rightSum)
			int rightSum = 0;

			for (int j = i + 1; j < n; j++)
				rightSum += arr[j];

			// split point index
			if (leftSum == rightSum)
				return i + 1;
		}

		// if it is not possible to
		// split array into two parts
		return -1;
	}

}

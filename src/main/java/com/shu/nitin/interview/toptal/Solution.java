package com.shu.nitin.interview.toptal;

public class Solution {

	public String solution(String[] A, String[] B, String P) {
		String match = "NO CONTACT";
		int matchIndex = findIndex(A, B, P);
		if (matchIndex != -1) {
			match = A[matchIndex];
		}
		return match;
	}

	private int findIndex(String[] A, String[] B, String P) {
		int index = -1;
		for (int i = 0; i < B.length; i++) {
			if (null != B[i] && B[i].contains(P)) {
				index = finalIndex(A, index, i);
			}
		}
		return index;
	}

	private int finalIndex(String[] A, int index, int i) {
		int finalIndex = i;
		if (index != -1 && A[index].length() < A[i].length()) {
			finalIndex = index;
		}
		return finalIndex;

	}

}

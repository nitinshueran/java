package com.shu.nitin.companies.zalando;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Problem2 {

	public static void main(String[] args) {
		String underCheck = "aaaabbbccc";
		System.out.println(minDeletion(underCheck));
	}

	private static int minDeletion(String underCheck) {

		Map<Character, Integer> frequency = new HashMap<>();
		for (Character c : underCheck.toCharArray()) {
			if (frequency.containsKey(c)) {
				int value = frequency.get(c);
				frequency.put(c, value + 1);
			} else {
				frequency.put(c, 1);
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		for (Entry<Character, Integer> entry : frequency.entrySet()) {
			pq.add(entry.getValue());
		}
		int cntChar = 0;
		// Traverse the priority_queue
		while (!pq.isEmpty()) {
			// Stores topmost
			// element of pq
			int frequent = pq.peek();

			// Pop the topmost element
			pq.remove();

			// If pq is empty
			if (pq.isEmpty()) {

				// Return cntChar
				return cntChar;
			}

			// If frequent and topmost
			// element of pq are equal
			if (frequent == pq.peek()) {
				// If frequency of the topmost
				// element is greater than 1
				if (frequent > 1) {
					// Insert the decremented
					// value of frequent
					pq.add(frequent - 1);
				}

				// Update cntChar
				cntChar++;
			}
		}

		return cntChar;

	}

}

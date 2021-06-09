package com.shu.nitin.companies.interview;

public class ReverseString {

	public static void main(String[] args) {
		StringBuffer stringToReverse = new StringBuffer("We need to reverse this string");
		reverse(stringToReverse);
		System.out.println("Reversed string is: " + stringToReverse.toString());
	}

	private static StringBuffer reverse(StringBuffer stringToReverse) {
		int i = 0, start = 0, end = 0;
		while (i < stringToReverse.length()) {
			if (stringToReverse.charAt(i) == ' ') {
				end = i - 1;
				swap(stringToReverse, start, end);
				start = i + 1;
			}
			i++;
		}
		return stringToReverse;
	}

	private static void swap(StringBuffer stringToReverse, int start, int end) {
		while (start < end) {
			char temp = stringToReverse.charAt(end);
			stringToReverse.setCharAt(end, stringToReverse.charAt(start));
			stringToReverse.setCharAt(start, temp);
			start--;
			end++;
		}

	}
}

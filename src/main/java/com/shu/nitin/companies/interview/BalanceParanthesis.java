package com.shu.nitin.companies.interview;

import java.util.Stack;

public class BalanceParanthesis {

	public static void main(String[] args) {

		System.out.println("This program will check if paranthesis are balanced in a string or not");
		System.out.println(checkBalancedParanthesis("()"));
		System.out.println(checkBalancedParanthesis("{+1(23+34)}"));
		System.out.println(checkBalancedParanthesis("{()}"));
		System.out.println(checkBalancedParanthesis("{(()}"));

	}

	private static boolean checkBalancedParanthesis(String value) {
		boolean paranthesisBalanced = false;
		Stack<Character> paranthesisStack = new Stack<>();
		for (Character ch : value.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				paranthesisStack.push(ch);
			} else if (ch == ')') {
				if (paranthesisStack.isEmpty() || paranthesisStack.peek() != '(') {
					return paranthesisBalanced;
				} else {
					paranthesisStack.pop();
				}
			} else if (ch == '}') {
				if (paranthesisStack.isEmpty() || paranthesisStack.peek() != '{') {
					return paranthesisBalanced;
				} else {
					paranthesisStack.pop();
				}
			} else if (ch == '}') {
				if (paranthesisStack.isEmpty() || paranthesisStack.peek() != '{') {
					return paranthesisBalanced;
				} else {
					paranthesisStack.pop();
				}
			}
		}
		return paranthesisStack.isEmpty();
	}
}

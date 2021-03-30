package com.shu.nitin.sumup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Test {

    private static final Map<Character, Character> CLOSING = new HashMap<>();;

    public Test() {
	CLOSING.put('(', ')');
	CLOSING.put('{', '}');
	CLOSING.put('[', ']');
    }

    public static void main(String[] args) {
	System.out.println(Test.orderWeight("59544965313 496636983114762 85246814996697"));
	System.out.println(new Test().isValid("[()]"));
    }

    public static String orderWeight(String strng) {

	TreeMap<Integer, String> map = new TreeMap<>();

	for (int i = 0; i < strng.length(); i++) {
	    if (Character.isDigit(strng.charAt(i))) {
		long number = Character.getNumericValue(strng.charAt(i));
		int sum = (int) number;
		// peek next
		while (i + 1 < strng.length() && Character.isDigit(strng.charAt(i + 1))) {
		    int numval = Character.getNumericValue(strng.charAt(i + 1));
		    sum += numval;
		    number = number * 10 + numval;
		    i++;
		}
		i++;
		if (map.containsKey(sum)) {
		    String[] arr = map.get(sum).concat(" ").concat(String.valueOf(number)).split(" ");
		    Arrays.sort(arr);
		    String sorted = arr[0];
		    for (int j = 1; j < arr.length; j++) {
			sorted = sorted.concat(" ").concat(arr[j]);
		    }
		    map.put(sum, sorted);
		} else {
		    map.put(sum, String.valueOf(number));
		}

	    }
	}
	StringBuilder sb = new StringBuilder();
	for (Entry<Integer, String> entry : map.entrySet()) {
	    sb.append(entry.getValue()).append(" ");
	}
	return sb.toString().trim();
    }

    public boolean isValid(String braces) {

	Set<Character> validKeys = Test.CLOSING.keySet();

	if (null != braces && braces.length() > 1 && braces.length() % 2 == 0) {
	    Stack<Character> validator = new Stack<>();
	    for (char brace : braces.toCharArray()) {
		if (validKeys.contains(brace)) {
		    validator.push(brace);
		} else if (validator.size() > 0 && brace == Test.CLOSING.get((Character) validator.peek())) {
		    validator.pop();
		}else {
		    return false; 
		}
	    }
	    return validator.isEmpty();

	}
	return false;
    }

}

package com.shu.nitin.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShiftCharInString {
    public static void main(String[] args) {
        System.out.println(shiftAndCheckEquality("abcdea", "cdeab"));
    }

    private static boolean shiftAndCheckEquality(String s, String goal) {
        if (s.isEmpty() && goal.isEmpty()) {
            return true;
        }
        Queue<Character> queue = new LinkedList<>();
        char[] sChars = s.toCharArray();
        char start = goal.charAt(0);
        int i = 0;
        for (char c : sChars) {

            if (c == start) {
                StringBuilder sb = new StringBuilder(s.substring(i, s.length()));
                while (!queue.isEmpty()) {
                    sb.append(queue.poll());
                }
                if (sb.toString().equals(goal)) {
                    return true;
                }
                break;
            } else {
                queue.add(c);
            }
            i++;
        }
        return false;
    }
}

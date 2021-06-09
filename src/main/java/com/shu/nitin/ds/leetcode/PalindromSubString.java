package com.shu.nitin.ds.leetcode;

import java.util.Arrays;

public class PalindromSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abb"));
        System.out.println(new PalindromSubString().lengthOfLongestSubstring("abca"));
        System.out.println(new PalindromSubString().isPalindrome(10));
        Thread t = new Thread(() -> System.out.print("Test"));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x >= 0 && x <= 9)
            return true;

        int quotient = x;
        int reverse = 0;
        while (quotient > 0) {
            reverse = quotient % 10 + reverse * 10;
            quotient = quotient / 10;
        }
        if (x == reverse)
            return true;

        return false;
    }

    public static String longestPalindrome(String s) {
        if (null == s || s.length() == 0 || s.length() == 1)
            return s;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                int length = sub.length();
                int start = length / 2 - 1;
                int end = length % 2 == 0 ? length / 2 : length / 2 + 1;
                while (start >= 0 && end < sub.length() && sub.charAt(start) == sub.charAt(end)) {
                    if ((r - l) < (end - start)) {
                        l = start + i;
                        r = end;
                    }
                    start--;
                    end++;

                }

            }
        }

        return s.substring(l, r + 1);
    }

    public int lengthOfLongestSubstring(String str) {
        int n = str.length();
        if (n <= 1)
            return n;
        int[] lastindex = new int[256];
        Arrays.fill(lastindex, -1);
        int start = 0;
        int res = 0;
        for (int j = 0; j < n; j++) {
            System.out.println(str.charAt(j));
            if (lastindex[str.charAt(j)] + 1 > start)
                start = lastindex[str.charAt(j)] + 1;
            res = Math.max(res, j - start + 1);
            lastindex[str.charAt(j)] = j;
        }
        return res;
    }

}

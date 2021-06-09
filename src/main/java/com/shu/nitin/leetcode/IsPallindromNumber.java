package com.shu.nitin.leetcode;

public class IsPallindromNumber {
    public static void main(String[] args) {
        System.out.println(isPallindrome(1001));
    }

    private static boolean isPallindrome(int num) {
        boolean isPallindrome = false;
        if (num >= 0) {
            int reverse = 0;
            int quotient = num;
            while (quotient > 0) {
                reverse = reverse * 10 + quotient % 10;
                quotient = quotient / 10;

            }
            if (reverse == num) {
                isPallindrome = true;
            }
        }
        return isPallindrome;
    }
}

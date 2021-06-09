package com.shu.nitin.companies.zalando;

public class LargestNumberInString {
    public static void main(String[] args) {
        String s = "505551";
        System.out.println(findMaxInString(s));
    }

    private static int findMaxInString(String s) {
        char[] chars = s.toCharArray();
        int max = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            int tmp = Character.getNumericValue(chars[i]) * 10 + Character.getNumericValue(chars[i + 1]);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}

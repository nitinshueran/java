package com.shu.nitin.companies.klarna;

public class Solution {

    public static void main(String[] args) {

    }

    public static String maskify2(String creditCardNumber) {
        char chars[] = creditCardNumber.toCharArray();
        if (creditCardNumber == null || creditCardNumber.length() == 0 || chars.length == 5) {
            return creditCardNumber;
        }
        String resString = "";

        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || i >= chars.length - 4) {
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                resString = resString + "#";
            } else {
                resString = resString + "" + chars[i];
            }

        }
        return resString;
    }

    // submitted
    public static String maskify(String creditCardNumber) {
        // Add code here
        if (null == creditCardNumber || creditCardNumber.length() == 0 || "".equals(creditCardNumber)
                || creditCardNumber.length() < 6)
            return creditCardNumber;
        return mask(creditCardNumber);
    }

    private static String mask(String creditCardNumber) {
        String tmpMasked = creditCardNumber.substring(1, creditCardNumber.length() - 4).replaceAll("[0-9]", "#");
        StringBuilder builder = new StringBuilder(creditCardNumber.substring(0, 1)).append(tmpMasked)
                .append(creditCardNumber.substring(creditCardNumber.length() - 4, creditCardNumber.length()));
        return builder.toString();
    }

}

package com.shu.nitin.companies.zalando;

public class BreakTheChain {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 2, 2, 4, 6, 3, 7 };
        System.out.println(breakTheChain(arr));
    }

    private static int breakTheChain(int[] arr) {
        int firstMin = 0;
        int secMin = 0;
        int thirdMin = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] <= arr[firstMin]) {
                thirdMin = secMin;
                secMin = firstMin;
                firstMin = i;
            } else if (arr[i] <= arr[secMin]) {
                thirdMin = secMin;
                secMin = i;
            } else if (arr[i] < arr[thirdMin])
                thirdMin = i;
        }
        if (firstMin - secMin > 1 || secMin - firstMin > 1)
            return arr[firstMin] + arr[secMin];
        else
            return arr[firstMin] + arr[thirdMin];
    }

}

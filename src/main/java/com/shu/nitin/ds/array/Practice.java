package com.shu.nitin.ds.array;

public class Practice {
    public static void main(String[] args) {
        int[] check = new int[3];
        check[0] = 2;
        check[1] = 2;
        check[2] = 3;
        System.out.println(findErrorNums(check));
    }

    public static int[] findErrorNums(int[] nums) {

        int dup = -1, miss = -1;
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                dup = Math.abs(num);
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return new int[] { dup, miss };

    }
}

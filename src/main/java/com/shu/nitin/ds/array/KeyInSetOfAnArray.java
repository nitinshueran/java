package com.shu.nitin.ds.array;

public class KeyInSetOfAnArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3 };
        int x = 3;
        int k = 3;
        System.out.println(keyExistInSet(arr, x, k));
    }

    private static boolean keyExistInSet(int[] arr, int x, int k) {
        if (null != arr && arr.length > k) {
            int i = 0;
            int count = 1;

            while (i < arr.length) {
                if (count <= k) {
                    if (arr[i] == x) {
                        i += k;
                        count = 1;
                    } else {
                        count++;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}

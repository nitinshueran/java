package com.shu.nitin.ds.array;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 4, 2 };
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        for (int element : arr)
            System.out.println(element);

    }
}

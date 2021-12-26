package com.learn.ds.tp;

import java.util.Arrays;

public class DutchFlag {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int index = 0;
        while (index <= j) {
            if (arr[index] == 0) {
                swap(arr, i++, index++);
            } else if (arr[index] == 2) {
                swap(arr, j--, index);
            } else if (arr[index] == 1) {
                index++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

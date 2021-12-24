package com.learn.ds.tp;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(remove(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
        System.out.println(remove(new int[] { 2, 2, 2, 11 }));
    }

    public static int remove(int[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            } else {
                i++;
                swap(arr, i, j);
                j++;
            }
        }
        return i + 1;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

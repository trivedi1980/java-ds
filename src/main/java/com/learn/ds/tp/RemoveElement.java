package com.learn.ds.tp;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(RemoveElement.remove(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(RemoveElement.remove(arr, 2));
        System.out.println(RemoveElement.remove(new int[] {1, 1, 1}, 1));
    }

    public static int remove(int[] arr, int key) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] == key) {
                swap(arr, i, j);
                j--;
            } else {
                i++;
            }
        }
        return i;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

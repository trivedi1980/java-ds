package com.learn.ds.tp;

public class SortedArraySquares {
    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

    public static int[] makeSquares(int[] arr) {
        int[] res = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        int index = arr.length - 1;

        while (i < j) {
            int p1 = arr[i] * arr[i];
            int p2 = arr[j] * arr[j];
            if (p1 > p2) {
                res[index] = p1;
                i++;
            } else {
                res[index] = p2;
                j--;
            }
            index--;
        }
        return res;
    }
}

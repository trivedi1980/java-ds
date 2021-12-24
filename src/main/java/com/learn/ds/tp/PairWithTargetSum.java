package com.learn.ds.tp;

import java.util.Arrays;

public class PairWithTargetSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(search(new int[] {1, 2, 3, 4, 6}, 6)));
        System.out.println(Arrays.toString(search(new int[] {2, 5, 9, 11}, 11)));
    }

    public static int[] search(int[] arr, int targetSum) {
        int[] res = new int[] { -1, -1};
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == targetSum) {
                res[0] = i;
                res[1] = j;
                break;
            } else if (sum > targetSum) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}

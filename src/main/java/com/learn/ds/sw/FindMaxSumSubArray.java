package com.learn.ds.sw;

public class FindMaxSumSubArray {
    public static void main(String[] args) {
        int data[] = new int[] {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(findMaxSum(data, k));
        System.out.println(findMaxSum(new int[] {2, 3, 4, 1, 5}, 2));
    }

    public static int findMaxSum(int[] data, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            count = count + data[i];
        }

        int size = data.length - k + 1;
        int wl = 0;
        int wr = k - 1;
        for (int i = 0; i < size; i++) {
            sum = Math.max(sum, count);
            wl++;
            wr++;
            if (wr < data.length) {
                count = count + data[wr] - data[wl - 1];
            }
        }
        return sum;
    }

}

package com.learn.ds.sw;

public class FindSmallestSubArray {
    public static void main(String[] args) {
        int[] data = new int[] {2, 1, 5, 2, 3, 2};
        int sum = 7;
        System.out.println(findSmallestSubArray(data, sum));
        System.out.println(findSmallestSubArray(new int[] {2, 1, 5, 2, 8}, 7));
        System.out.println(findSmallestSubArray(new int[] {3, 4, 1, 1, 6}, 8));
    }

    private static int findSmallestSubArray(int[] data, int sum) {
        int count = Integer.MAX_VALUE;
        int wl = 0;
        int wr = 0;
        int windowSum = 0;
        for (int i = 0; i < data.length; i++) {
            windowSum += data[i];
            if (windowSum >= sum) {
                wr = i;
                break;
            }
        }

        while (wr < data.length) {
            count = Math.min(count, wr - wl + 1);
            windowSum = windowSum - data[wl];
            wl++;
            while (windowSum < sum) {
                wr++;
                if (wr < data.length)
                    windowSum = windowSum + data[wr];
                else
                    break;
            }
        }
        return count;
    }
}

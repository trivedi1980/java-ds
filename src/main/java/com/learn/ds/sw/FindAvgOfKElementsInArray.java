package com.learn.ds.sw;

import java.util.Arrays;

public class FindAvgOfKElementsInArray {
    public static void main(String[] args) {
        int data[] = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        System.out.println(Arrays.toString(average(data, k)));
    }

    public static float[] average(int[] data, int k) {
        float sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + data[i];
        }
        int items = data.length - k + 1;
        float response [] = new float[items];
        int wl = 0;
        int wr = k -1;
        for (int i = 0; i < items; i++) {
            response[i] = (sum * 1.0f) / k;
            wr++;
            wl++;
            if (wr < data.length)
                sum = sum + data[wr] - data[wl -1];
        }
        return response;
    }
}

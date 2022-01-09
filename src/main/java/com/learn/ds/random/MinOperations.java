package com.learn.ds.random;

import java.util.Arrays;

public class MinOperations {
    public static int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        int[] left = new int[boxes.length()];
        int[] right = new int[boxes.length()];
        int count = boxes.charAt(0) == '1' ? 1 : 0;
        left[0] = 0;
        for (int i = 1; i < boxes.length(); i++) {
            left[i] = left[i - 1] + count;
            if (boxes.charAt(i) == '1') {
                count++;
            }
        }

        count = boxes.charAt(boxes.length() - 1) == '1' ? 1 : 0;
        right[boxes.length() -1] = 0;
        for (int i = boxes.length() - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            if (boxes.charAt(i) == '1') {
                count++;
            }
        }

        for (int i = 0; i < boxes.length(); i++) {
            result[i] = left[i] + right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("110")));
    }
}

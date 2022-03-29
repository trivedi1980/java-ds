package com.learn.ds.array;

import java.util.*;

public class MinIncrementForUniqueArray {
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }

    public static int minDeletions(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int[] values = new int[freq.values().size()];
        int i = 0;
        for (int each : freq.values()) {
            values[i++] = each;
        }
        Arrays.sort(values);

        int count = 0;
        for (i = values.length - 2; i >= 0; i--) {
            if (values[i] >= values[i+1]) {
                int reduce = values[i] - values[i+1];
                count += reduce + 1;
                values[i] -= (reduce + 1);
                if (values[i] < 0) {
                    count += values[i];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // System.out.println(minIncrementForUnique(new int[] {3,2,1,2,1,7}));
        System.out.println(minDeletions("ceabaacb"));
    }
}

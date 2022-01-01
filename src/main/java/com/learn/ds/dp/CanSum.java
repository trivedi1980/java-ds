package com.learn.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        Map<Integer, Boolean> memo = new HashMap<>();
        System.out.println(canSum(7, new int [] {2, 3, 4, 7}, memo));
        memo.clear();
        System.out.println(canSum(7, new int [] {2, 4}, memo));
        memo.clear();
        System.out.println(canSum(300, new int [] {7, 14}, memo));
    }

    private static boolean canSum(int target, int[] nums, Map<Integer, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return true;
        if (target < 0) return false;

        for (int i = 0; i < nums.length; i++) {
            if (canSum(target - nums[i], nums, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }
}

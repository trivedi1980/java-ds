package com.learn.ds.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        System.out.println(howSum(300, new int[]{7, 14}, memo));
        memo.clear();
    }

    private static List<Integer> howSum(int target, int[] nums, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        for (int i = 0; i < nums.length; i++) {
            List<Integer> items = howSum(target - nums[i], nums, memo);
            if (items != null) {
                List<Integer> list = new ArrayList<>(items);
                list.add(nums[i]);
                memo.put(target, list);
                return items;
            }
        }
        memo.put(target, null);
        return null;
    }
}

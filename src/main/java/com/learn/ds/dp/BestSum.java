package com.learn.ds.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}, memo));
        memo.clear();
        System.out.println(bestSum(8, new int[]{2, 3, 5}, memo));
        memo.clear();
        System.out.println(bestSum(8, new int[]{1, 4, 5}, memo));
        memo.clear();
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}, memo));
    }

    private static List<Integer> bestSum(int target, int[] nums, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        List<Integer> bestList = null;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = bestSum(target - nums[i], nums, memo);
            if (list != null) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums[i]);
                bestList = bestList != null && bestList.size() < newList.size() ? bestList : newList;
            }
        }
        memo.put(target, bestList);
        return bestList;
    }
}

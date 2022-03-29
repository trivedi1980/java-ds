package com.learn.ds.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequenceOfKSize {
    private List<Integer> maxList = null;
    private int max = 0;
    public int[] maxSubsequence(int[] nums, int k) {
        dfs(0, nums, k, new ArrayList<>());
        if (maxList == null) return new int[0];

        int[] result = new int[maxList.size()];
        for (int i = 0; i < maxList.size(); i++) {
            result[i] = maxList.get(i);
        }
        return result;
    }

    private void dfs(int index, int[] nums, int k, List<Integer> path) {
        if (path.size() == k) {
            int newMax = sum(path);
            if (newMax > max) {
                max = newMax;
                maxList = new ArrayList<>(path);
            }
            return;
        }
        if (index < 0 || index >= nums.length) return;

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i + 1, nums, k, path);
            path.remove(path.size() - 1);
        }
    }

    private int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        FindSubsequenceOfKSize instance = new FindSubsequenceOfKSize();
        instance.maxSubsequence(new int[] {2,1,3,3}, 2);
    }
}

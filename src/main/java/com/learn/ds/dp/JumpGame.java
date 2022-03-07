package com.learn.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {
    int count = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        dfs(0, nums, nums.length - 1, new ArrayList<>());
        return count == Integer.MAX_VALUE ? 0 : count;
    }

    private void dfs(int index, int[] nums, int target, List<Integer> path) {
        if (target <= 0) {
            count = Math.min(count, path.size());
            return;
        }
        if (nums[index] == 0) return;

        path.add(nums[index]);
        for(int i = index + 1; i <= index + nums[index] && i < nums.length; i++) {
            dfs(i, nums, target - Math.min(nums[index], i - index), path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.jump(new int[] { 3, 4, 3, 2, 5, 4, 3}));
    }
}

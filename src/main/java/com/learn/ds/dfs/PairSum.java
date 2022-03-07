package com.learn.ds.dfs;

import java.util.ArrayList;
import java.util.List;

public class PairSum {
    public static long largestValue(List<Integer> A) {
        // Return the largest value of any of A's nonempty subarrays.
        long result = Long.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++)
            result = Math.max(result, dfs(i, j,  A));
        }
        return result;
    }

    private static long dfs(int s, int e, List<Integer> array) {
        if (s < 0 || e > array.size() - 1 || s >= e) return 0;

        long sum = 0;
        for (int i = s+1; i <= e; i++) {
            sum += (array.get(s) * array.get(i));
        }
        if (s+1 < e)
            sum += dfs(s+1, e, array);
        return sum;
    }
    public static void main(String[] args) {
        // -3 7 -2 3 5 -2
        List<Integer> list = new ArrayList<>();
        /*list.add(-3);
        list.add(7);
        list.add(-2);
        list.add(3);
        list.add(5);
        list.add(-2);*/
        // 5 7 -5 6 3 9 -8 2 -1 10
        list.add(5);
        list.add(7);
        list.add(-5);
        list.add(6);
        list.add(3);
        list.add(9);
        list.add(-8);
        list.add(2);
        list.add(-1);
        list.add(10);
        /*list.add(7);
        list.add(2);
        list.add(-1);
        list.add(2);*/
        System.out.println(largestValue(list));
    }
}

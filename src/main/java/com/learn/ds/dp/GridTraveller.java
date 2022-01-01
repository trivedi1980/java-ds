package com.learn.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
    public static void main(String[] args) {
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(gridTraveler(2, 3, memo));
    }

    private static int gridTraveler(int m, int n, Map<String, Integer> memo) {
        String key1 = m + "+" + n;
        String key2 = n + "+" + m;
        if (memo.containsKey(key1)) return memo.get(key1);
        if (memo.containsKey(key2)) return memo.get(key2);
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        int value = gridTraveler(m-1, n, memo) + gridTraveler(m, n-1, memo);
        memo.put(key1, value);
        memo.put(key2, value);

        return value;
    }
}

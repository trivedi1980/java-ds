package com.learn.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonocci {
    public static void main(String[] args) {
        Map<Integer, Long> memo = new HashMap<>();
        System.out.println(fib(50, memo));
        // System.out.println(fib(7));
        // System.out.println(fib(8));
    }

    private static long fib(int num, Map<Integer, Long> memo) {
        if (memo.containsKey(num)) return memo.get(num);
        if (num <= 2) return 1;
        long value = fib(num - 1, memo) + fib(num - 2, memo);
        memo.put(num, value);
        return value;
    }
}

package com.learn.ds.dp;

public class PerfectSquares {
    public static int numSquares(int n) {
        return sum(n);
    }

    private static int sum(int n) {
        if (n <= 0) return 0;

        int count = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                count = Math.min(count, 1 + sum(n - i * i));
            } else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}

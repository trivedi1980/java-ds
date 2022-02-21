package com.learn.ds.dp;

public class DecodeWays {
    public static int numDecodings(String s) {
        return findWays(s, 0);
    }

    private static int findWays(String s, int index) {
        if (index >= s.length()) return 1;
        if (s.charAt(index) == '0') return 0;

        int count = 0;
        for (int i = index; i < s.length(); i++) {
            int value = Integer.parseInt(s.substring(index, i+1));
            if (value >26) break;
            count += findWays(s, i+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("2222"));
    }
}

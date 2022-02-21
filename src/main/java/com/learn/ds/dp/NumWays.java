package com.learn.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class NumWays {

    public static int numWays2(String[] words, String target) {
        int n = target.length();
        long mod = (long)1e9 + 7, res[] = new long[n + 1];
        res[0] = 1;
        for (int i = 0; i < words[0].length(); ++i) {
            int[] count = new int[26];
            for (String w : words)
                count[w.charAt(i) - 'a']++;
            for (int j = n - 1; j >= 0; --j) {
                res[j + 1] += res[j] * count[target.charAt(j) - 'a'] % mod;
            }
        }
        return (int)(res[n] % mod);
    }

    private static long mod = (long) (Math.pow(10, 9) + 7);
    public static int numWays(String[] words, String target) {
        Map<String, Integer> memo = new HashMap<>();
        char[][] charWords = new char[words.length][words[0].length()];
        int i = 0;
        for (String word : words) {
            charWords[i++] = word.toCharArray();
        }

        return findWays(charWords, target.toCharArray(), 0, 0, memo);
    }

    private static int findWays(char[][] words, char[] target,
                         int tIndex,
                         int wIndex,
                         Map<String, Integer> memo) {
        String key = tIndex + "," + wIndex;
        if (memo.containsKey(key)) return memo.get(key);
        if (tIndex >= target.length) return 1;
        if (wIndex >= words[0].length) return 0;

        long count = 0;
        char ch = target[tIndex];
        for (char[] word : words) {
            for (int i = wIndex; i< word.length; i++) {
                if (ch == word[i]) {
                    count += (findWays(words, target, tIndex + 1, i + 1, memo) % mod);
                }
            }
        }
        memo.put(key, (int)(count % mod));
        return memo.get(key);
    }

    public static void main(String[] args) {
        System.out.println(numWays2(new String[] {
                "ab","ab"
        }, "ab"));

        //["acca","bbbb","caca"]
        //"aba"
    }
}

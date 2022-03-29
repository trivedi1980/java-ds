package com.learn.ds;

import java.util.*;

public class SmallestSubSequence {
    public static String smallestSubsequence(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        char[] chars = new char[freq.keySet().size()];
        int i = -1;
        Set<Character> inserted = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (!inserted.contains(ch)) {
                while (i >= 0 && chars[i] > ch && freq.get(chars[i]) > 1) {
                    inserted.remove(chars[i]);
                    freq.put(chars[i], freq.get(chars[i]) - 1);
                    i--;
                }
                inserted.add(ch);
                chars[++i] = ch;
            } else {
                freq.put(ch, freq.get(ch) - 1);
            }
        }
        return new String(chars);
    }

    public static int minSwaps(int[][] grid) {
        int[] tzero = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            tzero[i] = count;
        }

        int count = 0;
        for (int i = 0; i < tzero.length - 1; i++) {
            int swaps = bubbleSort(tzero, i, tzero.length - 1 - i);
            if (swaps == -1) return -1;
            count += swaps;
        }
        return count;
    }

    private static int bubbleSort(int[] arr, int index, int value) {
        if (arr[index] >= value) return 0;

        int i;
        for (i = index + 1; i < arr.length; i++) {
            if (arr[i] >= value) break;
        }
        if (i >= arr.length) return -1;

        for (int j = i; j > index; j--) {
            swap(arr, j, j-1);
        }
        return i - index;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int numRollsToTarget(int n, int k, int target) {
        if (n == 0) return 0;
        Map<String, Integer> memo = new HashMap<>();
        return rollsCount(n, k, target, memo);
    }

    private static int rollsCount(int n, int k, int target, Map<String, Integer> memo) {
        String key = n + "-" + target;
        if (n == 0 && target == 0) return 1;
        if (n <=0 || target < 0) return 0;
        if (memo.containsKey(key)) return memo.get(key);

        int count = 0;
        for (int j = 1; j <= k; j++) {
            count += rollsCount(n-1, k, target - j, memo);
            count = count % 1000000007;
        }
        memo.put(key, count);
        return memo.get(key);
    }

    public static int findSubstringInWraproundString(String p) {
        //(char)( 'a' + ('h' - 'a' + 1) %26 )
        int[] dp = new int[p.length()];
        char ch1 = '\0';
        dp[p.length() - 1] = 1;
        Set<Character> included = new HashSet<>();
        included.add(p.charAt(p.length() - 1));

        for (int i = p.length() - 2; i >= 0; i--) {
            char ch = p.charAt(i);

            included.add(ch);
            if (nextChar(ch) == p.charAt(i + 1)) {
                dp[i] = 1 + dp[i + 1];
            } else {
                included.clear();
                dp[i] = 1;
            }
        }

        return Arrays.stream(dp).sum();
    }

    private static char nextChar(char ch) {
        return (char) ('a' + (ch - 'a' + 1) % 26);
    }

    public static void main(String[] args) {
        // System.out.println(smallestSubsequence("bcbcbcababa"));
        /*System.out.println(minSwaps(new int[][] {
                //{0,0,1},{1,1,0},{1,0,0}
                {1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}
        }));*/

       // System.out.println(numRollsToTarget(30, 30 ,500));

        System.out.println(findSubstringInWraproundString("cac"));
    }
}

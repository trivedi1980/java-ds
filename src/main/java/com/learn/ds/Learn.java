package com.learn.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Learn {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("lint");
        strings.add("code");
        strings.add("love");
        strings.add("you");
        String encode = encode(strings);
        strings = decode(encode);
        System.out.println(strings);
    }

    public static String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length() + "#" + str);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        // write your code here
        List<String> results = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int length = 0;
            int j = i;
            while (j < str.length() && str.charAt(j) != '#') {
                length = length * 10 + Character.getNumericValue(str.charAt(j));
                j++;
            }

            results.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return results;
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int a = 1; a < dp.length; a++) {
            for (int j = 0; j < coins.length; j++) {
                if (a - coins[j] >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - coins[j]]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '0') {
                dp[i] = 0;
            } else {
                dp[i] = i + 1 < s.length() ? dp[i + 1] : 1;
            }

            if (i + 1 < s.length() && (ch == '1' ||
                    (ch == '2' && (s.charAt(i+1) >= '0'
                            || s.charAt(i+1) <= '6')))) {
                dp[i] = dp[i] + dp[i+2];
            }
        }
        return dp[0];
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) return 0;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }

        double max = Double.MIN_VALUE;
        int ws = 0;
        int we = k - 1;

        while (we < nums.length) {
            double avg = (sum * 1.0) / k;
            max = max == Double.MIN_VALUE ? avg : Math.max(max, avg);
            sum = sum - nums[ws];
            ws++;
            we++;
            if (we < nums.length) {
                sum = sum + nums[we];
            }
        }
        return max;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pFreq = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pFreq.put(ch, pFreq.getOrDefault(ch, 0) + 1);
        }

        int ws = 0;
        int we = p.length() - 1;
        List<Integer> indexes = new ArrayList<>();

        while (we < s.length()) {
            if (isAnagram(s, ws, we, pFreq)) {
                indexes.add(ws);
            }
            ws++;
            we++;
        }
        return indexes;
    }

    private static boolean isAnagram(String s, int ws, int we, Map<Character, Integer> pFreq) {
        Map<Character, Integer> wFreq = new HashMap<>();
        for (int i = ws; i <= we; i++) {
            char ch = s.charAt(i);
            wFreq.put(ch, wFreq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : pFreq.keySet()) {
            if (!wFreq.containsKey(ch) || !(wFreq.get(ch).equals(pFreq.get(ch)))) return false;
        }
        return true;
    }
}

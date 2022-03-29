package com.learn.ds;

import java.util.*;

public class Learn {
    public static void main(String[] args) {
        System.out.println(maxTaxiEarnings(11, new int[][] {
                {1,10,5000},{2,6,14},{3,6,155}
        }));
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (r1, r2) -> r1[0] - r2[0]);
        long max = 0;
        for (int i = 0; i < rides.length; i++) {
            max = Math.max(findMax(i, rides), max);
        }
        return max;
    }

    private static long findMax(int index, int[][] rides) {
        if (index >= rides.length) return 0;

        int[] ride = rides[index];
        long result = getProfit(ride);

        for (int i = index+1; i < rides.length; i++) {
            int[] curr = rides[i];
            if (isOverlap(ride, curr)) continue;
            result = Math.max(getProfit(ride) + findMax(i, rides), result);
        }

        return result;
    }

    private static long getProfit(int[] ride) {
        return (ride[1] - ride[0] + ride[2]);
    }

    private static boolean isOverlap(int[] r1, int[] r2) {
        if (r1[1] > r2[0]) return true;
        return false;
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int ws = 0;
        int we = 0;

        Map<Character, Integer> freq = new HashMap<>();
        int count = 0;

        while (we < answerKey.length()) {
            char ch = answerKey.charAt(we);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (freq.keySet().size() > 1 && (we - ws + 1 - findMaxCount(freq)) > k) {
                char temp = answerKey.charAt(ws);
                ws++;
                freq.put(temp, freq.get(temp) - 1);
                if (freq.get(temp) == 0) {
                    freq.remove(temp);
                }
            }
            count = Math.max(count, we - ws + 1);
            we++;
        }
        return count;
    }

    private static int findMaxCount(Map<Character, Integer> freq) {
        int max = 0;

        for (char ch : freq.keySet()) {
            max = Math.max(max, freq.get(ch));
        }
        return max;
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        List<int[]> list = new ArrayList<>();

        int ws = 0;
        int we = 0;

        while (we < s.length()) {
            while(ws < s.length() && s.charAt(ws) != '|') {
                ws++;
            }

            we = ws + 1;
            while (we < s.length() && s.charAt(we) != '|') {
                we++;
            }

            if (we >= s.length()) break;

            if (we - ws > 1) {
                list.add(new int[] {ws, we, we-ws-1});
            }
            ws=we;
        }

        int[] result = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int minIndex = getMinIndex(list, query[0]);
            int maxIndex = getMaxIndex(list, query[1]);
            if (minIndex == -1 || maxIndex == -1) continue;

            if (minIndex <= maxIndex) {
                int count = 0;
                for (int i = minIndex; i <= maxIndex; i++) {
                    int[] item = list.get(i);
                    if (query[0] <= item[0] && query[1] >= item[1]) {
                        count = count + item[2];
                    }
                }
                result[index] = count;
            }
            index++;
        }
        return result;
    }

    private static int getMinIndex(List<int[]> list, int value) {
        int start = 0;
        int end = list.size() - 1;

        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] item = list.get(mid);
            if (item[0] >= value) {
                index = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }

    private static int getMaxIndex(List<int[]> list, int value) {
        int start = 0;
        int end = list.size() - 1;

        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] item = list.get(mid);
            if (item[1] <= value) {
                index = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });


        int[] result = new int[queries.length];
        int index = 0;
        for (int query : queries) {
            result[index++] = findResult(query, items);
        }
        return result;
    }

    private static int findResult(int query, int[][] items) {
        int start = 0;
        int end = items.length - 1;
        int result = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] item = items[mid];
            if (item[0] <= query) {
                result = Math.max(result, item[1]);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String result = countAndSay(n-1);
        int ws = 0;
        int we = 0;
        StringBuilder sb = new StringBuilder();
        while (we+1 < result.length()) {
            char ch = result.charAt(ws);
            char nextCh = result.charAt(we+1);
            if (ch != nextCh) {
                sb.append(we - ws + 1);
                sb.append(ch);
                ws = we+1;
                we = we+1;
            } else {
                we++;
            }
        }

        sb.append(we-ws +1);
        sb.append(result.charAt(ws));
        return sb.toString();
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

package com.learn.ds;

import java.util.*;

class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> freqMap = toFreqMap(str);
            String key = toKey(freqMap);
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());
            }
            groupMap.get(key).add(str);
        }

        List<List<String>> results = new ArrayList<>();
        for (String key : groupMap.keySet()) {
            results.add(groupMap.get(key));
        }
        return results;
    }

    private static Map<Character, Integer> toFreqMap(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq;
    }

    private static String toKey(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            sb.append('#');
            if (map.containsKey(ch))
                sb.append(map.get(ch));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}

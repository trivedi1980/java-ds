package com.learn.ds.graph;

import java.util.*;

public class AlighDict {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public static String alienOrder(String[] words) {
        // Write your code here
        Map<Character, Set<Character>> adj = new HashMap<>();

        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                adj.put(str.charAt(i), new HashSet<>());
            }
        }

        for (int i = 0 ; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int minLength = Math.min(w1.length(), w2.length());

            if (w1.substring(0, minLength).equals(w2.substring(0, minLength))
                    && w1.length() > w2.length()) {
                return "";
            }

            for (int j = 0; j < minLength; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                }
            }
        }

        Set<Character> visited = new HashSet<>();
        Set<Character> completed = new HashSet<>();
        List<Character> path = new ArrayList<>();

        // visit the nodes that has 0 adjacent nodes.
        StringBuilder sb = new StringBuilder();

        // visit the nodes that has adjacent nodes
        for (char each : adj.keySet()) {
            if (completed.contains(each)) continue;
            if (!dfs(each, adj, visited, completed, path)) return "";
        }

        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i));
        }
        return sb.toString();
    }

    private static boolean dfs(char ch, Map<Character, Set<Character>> adj,
                        Set<Character> visited, Set<Character> completed, List<Character> path) {
        if (visited.contains(ch) && !completed.contains(ch)) return false;
        if (completed.contains(ch)) return true;

        visited.add(ch);
        for (char each : adj.get(ch)) {
            if (!dfs(each, adj, visited, completed, path)) return false;
        }
        visited.remove(ch);
        completed.add(ch);
        adj.get(ch).clear();
        path.add(ch);
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"ab","adc"};
        System.out.println(alienOrder(words));
    }
}
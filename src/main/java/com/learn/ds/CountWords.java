package com.learn.ds;

import java.util.*;

public class CountWords {
    public static void displayWords(String sentence) {
        Map<String, Integer> freq = new HashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        Set<String> keySet = freq.keySet();
        List<String> keys = new ArrayList<>(keySet);
        Collections.sort(keys);

        for (String key : keys) {
            System.out.println(key + " : " + freq.get(key));
        }
    }
    
    public static void main(String[] args) {
        displayWords("i am learning data structures now");
    }
}

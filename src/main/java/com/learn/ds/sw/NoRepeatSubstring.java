package com.learn.ds.sw;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println(findLength("abccde"));
        System.out.println(findLength("abbbb"));
        System.out.println(findLength("aabccbb"));
        System.out.println(findLength("abcdef"));
    }

    public static int findLength(String str) {
        int ws = 0;
        int we = 0;
        Set<Character> visited = new HashSet<>();
        int length = 0;
        Character ch;

        while (we < str.length()) {
            ch = str.charAt(we);
            if (!visited.contains(ch)) {
                visited.add(ch);
                we++;
            } else {
                length = Math.max(length, we - ws);
                visited.clear();
                ws = we;
            }
        }

        if (we == str.length()) {
            length = Math.max(length, we - ws);
        }

        return length;
    }
}

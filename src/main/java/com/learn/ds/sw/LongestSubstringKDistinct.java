package com.learn.ds.sw;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength("cbbebi", 3));
        System.out.println(findLength("cbbebi", 10));
    }

    private static int findLength(String s, int k) {
        int ws = 0;
        int we = -1;
        Map<Character, Integer> charFreq = new HashMap<>();
        int length = 0;

        while (we < s.length()) {
            if (charFreq.keySet().size() > k) {
                length = Math.max(length, we - ws - 1);
                char ch = s.charAt(ws);
                ws++;
                charFreq.put(ch, charFreq.get(ch) - 1);
                if (charFreq.get(ch) == 0) {
                    charFreq.remove(ch);
                }
            } else {
                char ch = s.charAt(we);
                charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
                we++;
            }
        }
        if (charFreq.keySet().size() > k)
            length = Math.max(length, we - ws - 1);
        else
            length = Math.max(length, we - ws);
        return length;
    }
}

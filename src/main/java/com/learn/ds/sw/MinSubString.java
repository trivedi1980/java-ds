package com.learn.ds.sw;

import java.util.HashMap;
import java.util.Map;

class MinSubString {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int need = tMap.keySet().size();

        int ws = 0;
        int we = -1;
        int have = 0;
        Map<Character, Integer> wMap = new HashMap<>();
        int[] result = new int[2];
        int length = s.length() + 1;
        boolean found = false;

        while (we < s.length()) {
            char ch;

            if (have == need) {
                found = true;
                // t exits in window
                if (length > (we - ws + 1)) {
                    result[0] = ws;
                    result[1] = we + 1;
                    length = we - ws + 1;
                }

                ch = s.charAt(ws++);
                wMap.put(ch, wMap.get(ch) - 1);

                if (tMap.containsKey(ch) && wMap.get(ch) < tMap.get(ch)) {
                    have--;
                }

            } else {
                we++;
                if (we < s.length()) {
                    ch = s.charAt(we);
                    wMap.put(ch, wMap.getOrDefault(ch, 0) + 1);

                    if (tMap.containsKey(ch) && (tMap.get(ch) - wMap.get(ch)) == 0) {
                        have++;
                    }
                }
            }
        }

        return found ? s.substring(result[0], result[1]) : "";
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "aa"));
    }
}
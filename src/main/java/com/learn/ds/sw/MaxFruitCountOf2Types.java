package com.learn.ds.sw;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static void main(String[] args) {
        System.out.println(findLength(new char[] {'A', 'B', 'C', 'A', 'C'}));
        System.out.println(findLength(new char[] {'A', 'B', 'C', 'B', 'B', 'C'}));
    }

    public static int findLength(char[] arr) {
        int length = 0;
        int ws = 0;
        int we = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        Character ch;
        while (we < arr.length) {
            if (charCount.keySet().size() > 2) {
                length = Math.max(length, we - ws -1);
                ch = arr[ws];
                charCount.put(ch, charCount.get(ch) - 1);
                if (charCount.get(ch) == 0) {
                    charCount.remove(ch);
                }
                ws++;
            } else {
                ch = arr[we];
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
                we++;
            }
        }

        if (charCount.keySet().size() > 2) {
            length = Math.max(length, we - ws -1);
        } else {
            length = Math.max(length, we - ws);
        }
        return length;
    }
}

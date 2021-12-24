package com.learn.ds.sw;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }

    public static int findLength(String str, int k) {
        int len = 0;
        char count = 0;
        int ws = 0;
        int we = 0;
        char ch;
        while (we < str.length()) {
            if (count > k) {
                len = Math.max(len, we - ws - 1);
                ws++;
                we = ws;
                count = 0;
            } else {
                ch = str.charAt(we);
                if (ch != str.charAt(ws)) {
                    count++;
                }
                we++;
            }
        }
        if (count > k) {
            len = Math.max(len, we - ws - 1);
        } else {
            len = Math.max(len, we - ws);
        }
        return len;
    }
}

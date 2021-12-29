package com.learn.ds.tp;

public class BackspaceCompare {
    public static void main(String[] args) {
        //System.out.println(compare("xywrrmp", "xywrrmu#p"));
        System.out.println(backspaceCompare("bbbextm", "bbb#extm"));
    }

    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            i = getNextCharIndex(s, i);
            j = getNextCharIndex(t, j);
            if (i < 0 && j < 0) return true ;
            if (i < 0 || j < 0) return false;
            if (s.charAt(i) != t.charAt(j)) return false;
            i--;
            j--;
        }
        return true;
    }

    private static int getNextCharIndex(String str, int index) {
        int count = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }
}

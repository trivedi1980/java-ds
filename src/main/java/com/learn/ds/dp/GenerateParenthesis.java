package com.learn.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> strings = new ArrayList<>();
        dfs(n, 0, 0, 0, strings, new char[n * 2]);
        return strings;
    }

    private static void dfs(int n, int open, int close, int index,
                     List<String> strings,
                     char[] currentPath) {
        if (open > n || open < close || close > n) return;
        if (open == n && close == n) {
            strings.add(new String(currentPath));
            return;
        }

        currentPath[index] = '(';
        dfs(n, open + 1, close, index+1, strings, currentPath);
        currentPath[index] = ')';
        dfs(n, open, close + 1, index+1, strings, currentPath);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}

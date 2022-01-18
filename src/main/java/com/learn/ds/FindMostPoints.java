package com.learn.ds;

import java.util.HashMap;
import java.util.Map;

public class FindMostPoints {
    public static long mostPoints(int[][] questions) {
        int max = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < questions.length; i++) {
            max = Math.max(max, findMostPoints(i, questions, memo));
        }
        return max;
    }

    private static int findMostPoints(int index, int[][] questions, Map<Integer, Integer> memo) {
        if (index < 0 || index >= questions.length) return 0;
        if (memo.containsKey(index)) return memo.get(index);

        int points = questions[index][0];
        for (int i = index + questions[index][1] + 1; i < questions.length; i++) {
            points = Math.max(questions[index][0] + findMostPoints(i, questions, memo), points);
        }
        memo.put(index, points);
        return points;
    }

    public static void main(String[] args) {
        //[[3,2],[4,3],[4,4],[2,5]]
        /*System.out.println(mostPoints(new int[][] {
                {3, 2}, {4, 3}, {4, 4}, {2, 5}
        }));*/

        // [1,1],[2,2],[3,3],[4,4],[5,5]
        System.out.println(mostPoints(new int[][] {
                {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}
        }));
    }
}

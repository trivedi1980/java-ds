package com.learn.ds;

public class MinMoves {
    public static int minMoves(int target, int maxDoubles) {
        int moves = 0;

        while (maxDoubles > 0 && target > 2) {
            moves++;
            if (target % 2 == 0) {
                target = target / 2;
                maxDoubles--;
            } else {
                target--;
            }
        }
        if (target > 1)
            moves += target - 1;

        return moves;
    }

    public static void main(String[] args) {
        //System.out.println(minMoves(19, 2));
        //System.out.println(minMoves(5, 0));
        System.out.println(minMoves(10, 4));
    }
}

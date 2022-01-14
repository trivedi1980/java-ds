package com.learn.ds.graph;

import java.util.Arrays;

public class SurroundingRegions {
    public static void solve(char[][] board) {

        // scan borders and replace them with 'b'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 || j == 0 || i == board[i].length - 1 || j == board[i].length -1) {
                    replace(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void replace(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length) return;
        if (j < 0 || j >= board[i].length) return;

        if (board[i][j] == 'O') {
            board[i][j] = 'B'; // boarder
            replace(board, i + 1, j);
            replace(board, i - 1, j);
            replace(board, i, j + 1);
            replace(board, i, j - 1);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { 'X', 'O', 'X'},
                { 'O', 'X', 'O'},
                { 'X', 'O', 'X'}
        };
        solve(board);
        System.out.println(Arrays.toString(board));
    }
}

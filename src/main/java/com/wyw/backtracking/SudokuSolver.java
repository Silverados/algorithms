package com.wyw.backtracking;

import java.util.*;

public class SudokuSolver {
    static List<Set<Character>> rows =  new ArrayList<>();
    static List<Set<Character>> cols =  new ArrayList<>();
    static List<Set<Character>> blocks =  new ArrayList<>();

    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            blocks.add(new HashSet<>());
        }

        // init
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ('.' != board[i][j]) {
                    put(board, i, j);
                }
            }
        }

        int len = board.length;
        backtrace(board, len);
    }

    public static boolean backtrace(char[][] board, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(board, i, j, (char)(k + '0'))) {
                            board[i][j] = (char) (k + '0');
                            put(board, i, j);
                            if (backtrace(board, len)) {
                                return true;
                            }
                            remove(board, i, j);
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void put(char[][] board, int i, int j) {
        rows.get(i).add(board[i][j]);
        cols.get(j).add(board[i][j]);
        blocks.get(getBlock(i, j)).add(board[i][j]);
    }

    public static void remove(char[][] board, int i, int j) {
        rows.get(i).remove(board[i][j]);
        cols.get(j).remove(board[i][j]);
        blocks.get(getBlock(i, j)).remove(board[i][j]);
    }

    public static int getBlock(int i, int j) {
        return i / 3 * 3 + j / 3;
    }

    private static boolean isValid(char[][] board, int i, int j, char ch) {
        return !(ch == '.' || rows.get(i).contains(ch) ||
                cols.get(j).contains(ch) ||
                blocks.get(getBlock(i, j)).contains(ch));

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
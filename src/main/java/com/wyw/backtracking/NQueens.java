package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /**
     n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

     给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。

     每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/n-queens
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        backtrace(n, res, new int[n], 0);
        return res;
    }

    private static void backtrace(int len, List<List<String>> res, int[] columns, int columnIndex) {
        if (columnIndex == len) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len; j++) {
                    sb.append(j == columns[i] ? "Q" : ".");
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }

        for (int rowIndex = 0; rowIndex < len; rowIndex++) {
            columns[columnIndex] = rowIndex;
            if (isValid(columns, rowIndex, columnIndex)) {
                backtrace(len, res, columns, columnIndex + 1);
            }
        }
    }

    private static boolean isValid(int[] columns, int rowIndex, int columnIndex) {
        for (int i = 0; i < columnIndex; i++) {
            int diff = Math.abs(columns[i] - rowIndex);
            if (diff == 0 || columnIndex - i == diff) {
                return false;
            }
        }
        return true;
    }

    private static void print(List<List<String>> res) {
        res.forEach(list -> {
            list.forEach(System.out::println);
            System.out.println();
        });
    }

    public static void main(String[] args) {
        print(solveNQueens(4));
    }
}

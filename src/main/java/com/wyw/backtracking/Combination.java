package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    /**
     * https://leetcode-cn.com/problems/combinations/
     *
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     *
     * 你可以按 任何顺序 返回答案。
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrace(n, k, res, temp, 0);
        return res;
    }

    private static void backtrace(int n, int k, List<List<Integer>> res, List<Integer> temp, int index) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < n; i++) {
            // 剪枝
            if (temp.size() + n - i  < k) {
                break;
            }

            temp.add(i + 1);
            backtrace(n, k, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 3));
    }

}

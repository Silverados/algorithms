package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    /**
     * https://leetcode-cn.com/problems/permutations/
     * [1,2,3] -> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }

        backtrace(nums, nums.length, res, temp, 0);
        return res;
    }

    private static void backtrace(int[] nums, int len, List<List<Integer>> res, List<Integer> temp, int index) {
        if (index == len) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < len; i++) {
            Collections.swap(temp, i, index);
            backtrace(nums, len, res, temp, index + 1);
            Collections.swap(temp, i, index);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}

package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    /**
     * https://leetcode-cn.com/problems/subsets/
     * [1, 2, 3] ---> [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> temp = new ArrayList<>();
        backtrace(nums, res, temp, 0);
        return res;
    }

    private static void backtrace(int[] nums, List<List<Integer>> res, List<Integer> list, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

}

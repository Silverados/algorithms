package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {
    /**
     * 给你一个整数数组 nums 和一个整数 target 。
     * <p>
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * <p>
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/target-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> findTargetSumWays(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            temp.add(num);
            sum += num;
        }

        backtrace(nums.length, target, res, temp, 0, sum);
        return res;
    }

    private static void backtrace(int length, int target, List<List<Integer>> res, List<Integer> temp, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = index; i < length; i++) {
            temp.set(i, -temp.get(i));
            backtrace(length, target, res, temp, i + 1, sum + 2 * temp.get(i));
            temp.set(i, -temp.get(i));
        }

    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(findTargetSumWays(new int[]{1, 2, 3, 1, 1}, 4));
        System.out.println(findTargetSumWays(new int[]{1, 0, 0, 1, 1}, 1));
    }
}

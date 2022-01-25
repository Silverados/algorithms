package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /**
     * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        List<Integer> temp = new ArrayList<>();
        backtrace(candidates, target, res, temp, 0, 0);
        return res;
    }

    private static void backtrace(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            temp.add(candidates[i]);
            backtrace(candidates, target, res, temp, sum + candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}

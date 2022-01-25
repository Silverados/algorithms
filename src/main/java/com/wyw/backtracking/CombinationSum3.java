package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum3 {
    /**
     找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。

     说明：

     所有数字都是正整数。
     解集不能包含重复的组合。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/combination-sum-iii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] candidates = new int[9];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = i + 1;
        }
        backtrace(k, candidates, n, res, temp, 0, 0);
        return res;
    }

    private static void backtrace(int k, int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int sum, int index) {
        if (sum == target && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (temp.size() > k) {
                break;
            }
            if (sum + candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            backtrace(k, candidates, target, res, temp, sum + candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(3, 9));
    }

}

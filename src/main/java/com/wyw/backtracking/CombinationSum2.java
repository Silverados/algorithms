package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    /**
     给你一个由候选元素组成的集合 candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。

     candidates 中的每个元素在每个组合中只能使用 一次 。

     注意：解集不能包含重复的组合。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/combination-sum-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

        Arrays.sort(candidates);
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
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            backtrace(candidates, target, res, temp, sum + candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
    }

}

package com.wyw.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeautifulArrangement {

    /**
     * 假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
     *
     * perm[i] 能够被 i 整除
     * i 能够被 perm[i] 整除
     * 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/beautiful-arrangement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static List<List<Integer>> countArrangement(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        backtrace(n, used, res, temp);
        return res;
    }

    public static void backtrace(int n, boolean[] used, List<List<Integer>> res, List<Integer> temp) {
        if(temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!used[i] && isValid(temp.size() + 1, i)) {
                temp.add(i);
                used[i] = true;
                backtrace(n, used, res, temp);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> countArrangement2(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            temp.add(i);
        }
        backtrace2(n, res, temp, 0);
        return res;
    }

    private static void backtrace2(int n, List<List<Integer>> res, List<Integer> temp, int index) {
        if (index == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < n; i++) {
            if (isValid(index + 1, temp.get(i))) {
                Collections.swap(temp, i, index);
                backtrace2(n, res, temp, index + 1);
                Collections.swap(temp, i, index);
            }
        }
    }


    public static boolean isValid(int val, int index) {
        return val % index == 0 || index % val == 0;
    }

    public static void main(String[] args) {
        System.out.println(countArrangement2(4));
    }
}

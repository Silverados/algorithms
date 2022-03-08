package com.wyw.dynamicProgramming.subsequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * <p>
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestFibonacciSubsequence {

    /**
     * <pre>
     * 1.状态定义：
     *      dp[i] 表示以i结尾下标的最长斐波那契子序列的长度
     *      0 <= i < s.length()
     * 2.边界分析：
     *      if arr.length < 3:
     *          return false
     *      dp[0] = 0
     *      dp[1] = 0
     * 3.状态转移：
     *
     * </pre>
     *
     * @param arr
     * @return
     */
    public static int lenLongestFibSubseq_Base(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int count = 2;
                int sum = 0;
                int first = arr[i];
                int second = arr[j];
                while (set.contains((sum = first + second))) {
                    count++;
                    first = second;
                    second = sum;
                    if (count >= 3) {
                        max = Math.max(count, max);
                    }
                }
            }
        }
        return max;
    }

    public static int lenLongestFibSubseq(int[] arr) {
        // 以i结尾能形成的最长符合答案的序列
        List<List<Integer>> helper = new ArrayList<>();
        helper.add(new ArrayList<>());
        helper.add(new ArrayList<>());

        for (int i = 2; i < arr.length; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
    }
}

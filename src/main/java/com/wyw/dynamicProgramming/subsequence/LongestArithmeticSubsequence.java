package com.wyw.dynamicProgramming.subsequence;

/**
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestArithmeticSubsequence {

    /**
     * <pre>
     * 1.状态定义：
     *      dp[i][j]代表arr以i为开始下标、以j为结束下标的子序列的最大长度
     *      0 <= i <= j < arr.length
     * 2.边界分析：
     *      d[i][i] = 1
     * 3.状态转移：
     *      if arr[j] = arr[i] + * difference
     *      dp[i][j] =
     * </pre>
     * @param arr
     * @param difference
     * @return
     */
    public static int longestSubsequence(int[] arr, int difference) {
        return 0;
    }

}

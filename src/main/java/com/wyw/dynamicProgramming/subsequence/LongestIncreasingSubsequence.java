package com.wyw.dynamicProgramming.subsequence;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestIncreasingSubsequence {

    /**
     * <pre>
     * 1.状态定义：
     *      dp[i] 表示以i结尾下标的最长严格递归子序列的长度
     *      0 <= i < s.length()
     * 2.边界分析：
     *      dp[0] = 1
     *      dp[i] = 1
     * 3.状态转移：
     *      for j in range(0, i):
     *      if nums[j] < nums[i] :
     *          dp[i] = max(dp[j]) + 1
     *      else:
     *          dp[i] = dp[i]
     *
     *       return max(dp[i])
     * </pre>
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }



    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }
}

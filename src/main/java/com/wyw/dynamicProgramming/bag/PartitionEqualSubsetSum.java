package com.wyw.dynamicProgramming.bag;

public class PartitionEqualSubsetSum {
    /**
     * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-by-leetcode-solution/
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }

        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        int target = sum / 2;
        if (max > target) {
            return false;
        }

        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[len - 1][target];
    }
}

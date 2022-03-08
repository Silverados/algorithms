package com.wyw.dynamicProgramming.subarray;

/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class MaximumLengthRepeatedSubarray {

    /**
     * 1.状态定义：
     * dp[i][j]代表 nums1[0:i], nums2[0:j]公共的、长度最长的子数组长度
     * nums1[0:i]代表长度为i的nums1子数组
     * nums2[0:j]代表长度为j的nums2子数组
     * 2.边界分析：
     * dp[0][j] = 0
     * dp[i][0] = 0
     * 3.转移方程：
     * if nums1[i] == nums2[j]:
     * dp[i][j] = dp[i - 1][j - 1] + 1
     * else:
     * dp[i][j] = 0
     *
     * return max(dp[i][j])
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(findLength(new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0}));
        System.out.println(findLength(new int[]{1,2,3,2,1,1,2,3,4,5,1,34,34,5,23,46,5,4,2,34,5,43,3,32,26},
                new int[]{3,2,1,4,7,1,2,3,4,5,6,4,3,3,2,4,3}));
    }
}

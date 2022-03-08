package com.wyw.dynamicProgramming.subsequence;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonSubsequence {
    /**
     * 1.状态定义：
     *      dp[i][j] 表示 text1[0:i]和 text2[0:j]的最长公共子序列的长度
     *      0<=i<=text1.length, text1[0:i]表示text1的长度为i的前缀
     *      0<=j<=text2.length, text2[0:j]表示text2的长度为j的前缀
     * 2.边界分析：
     *      dp[0][j] = 0
     *      dp[i][0] = 0
     * 3.状态转移：
     *      if text1[i - 1] == text2[j - 1]:
     *          dp[i][j] = dp[i - 1][j - 1] + 1
     *      else
     *          dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcd", "arefbcg"));
    }
}

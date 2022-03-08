package com.wyw.dynamicProgramming.subsequence;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubsequence {
    /**
     * <pre>
     * 1.状态定义：
     *      dp[i][j] 表示以i为开始下标, j为结束下标的最长回文子序列的长度
     *      0 <= i <= j < s.length()
     * 2.边界分析：
     *      dp[i][i] = 1
     * 3.状态转移：
     *      if (s.charAt(i) == s.charAt(j)) :
     *          dp[i][j] = dp[i + 1][j - 1] + 2
     *      else:
     *          max(dp[i + 1][j], dp[i][j - 1])
     *
     *      return dp[0][s.length() - 1]
     * </pre>
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < len; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
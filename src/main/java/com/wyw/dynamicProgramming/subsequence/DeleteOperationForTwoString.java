package com.wyw.dynamicProgramming.subsequence;

import com.wyw.utils.ArrayUtils;

/**
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class DeleteOperationForTwoString {

    /**
     * 1.状态定义：
     *      dp[i][j] 表示 word1[0:i]和 t[0:j]的符合条件的最小步数
     *      0<=i<=word1.length, word1[0:i]表示word1的长度为i的前缀
     *      0<=j<=word2.length, word2[0:j]表示word2的长度为j的前缀
     * 2.边界分析：
     *      word1Len = word1.length(); word2Len = word2.length();
     *      dp[0][j] = j
     *      dp[i][0] = i
     * 3.状态转移：
     *      if word1[i] == word2[j]:
     *          dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
     *      else
     *          dp[i][j] = dp[i - 1][j - 1]
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        int[][] dp = new int[word1Len + 1][word2Len + 1];
        for (int i = 0; i <= word1Len; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= word2Len; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1Len; i++) {
            char ch1 = word1.charAt(i - 1);
            for (int j = 1; j <= word2Len; j++) {
                char ch2 = word2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[word1Len][word2Len];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sedasadf", "eafddt"));
//        System.out.println(minDistance("leetcode", "etco"));
    }
}

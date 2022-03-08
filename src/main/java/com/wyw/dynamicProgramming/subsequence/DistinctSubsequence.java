package com.wyw.dynamicProgramming.subsequence;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistinctSubsequence {

    /**
     * 1.状态定义：
     *      dp[i][j] 表示 s[0:i]和 t[0:j]的
     *      0<=i<=s.length, text[0:i]表示s的长度为i的前缀
     *      0<=j<=t.length, text[0:j]表示t的长度为j的前缀
     * 2.边界分析：
     *      sLen = s.length(); tLen = t.length();
     *      if sLen < tLen :
     *          return 0;
     *      elif sLen == tLen :
     *          return s.equals(t) ? 1 : 0;
     *
     *      if i < j :
     *          dp[i][j] = 0
     * 3.状态转移：
     *      if s[i] == t[j]:
     *          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
     *      else
     *          dp[i][j] = dp[i - 1][j]
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i < sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sLen; i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j <= i && j <= tLen; j++) {
                char tc = t.charAt(j - 1);
                if (sc == tc) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }
}

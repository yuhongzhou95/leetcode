package com.shadow.leetcode;

/**
 * 1143. 最长公共子序列
 * 第一次刷题：2020年8月7日17:39:02
 * 第二次刷题：2020年8月8日18:23:01
 */
public class Q1143 {

    /**
     * 解题思路：动态规划
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 获取两个串字符
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

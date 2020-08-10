package com.shadow.leetcode;

import java.util.Arrays;

/**
 * 62. 不同路径
 * 第一次刷题：2020年8月7日15:12:34
 */
public class Q62 {
    /**
     * 解题思路：动态规划
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 解题思路：动态规划优化（二维数组降为一维数组）
     * 至顶向下，从左到右
     * 例如 3 * 3
     * 第一次 1 1 1
     * 第二次 1 2 3
     * 第三次 1 3 6
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
}

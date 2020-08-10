package com.shadow.leetcode;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 第一次刷题：2020年8月8日18:22:52
 */
public class Q120 {

    /**
     * 解题思路：递归
     * 时间复杂度：O(2^n)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        return helper(0, 0, triangle);
    }

    private int helper(int m, int n, List<List<Integer>> triangle) {
        if (m == triangle.size()) {
            return 0;
        }
        int left = helper(m + 1, n, triangle);
        int right = helper(m + 1, n + 1, triangle);
        return Math.min(left, right) + triangle.get(m).get(n);
    }

    Integer[][] memo; // 定义记忆化数组

    /**
     * 递归 + 记忆化
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        // 递归终止条件
        if (i == triangle.size()) {
            return 0;
        }
        // 如果记忆化数组中有值，直接取出并返回，不进行后续的搜索。
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        // 递归式：f(i, j) = min(f(i + 1, j), f(i + 1, j + 1)) + triangle[i][j]
        // 结果返回之前存入记忆化数组。
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 时间复杂度：O(n*n) 为三角形的行数。
     * 空间复杂度：O(n*n) 为三角形的行数。
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i > -1; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

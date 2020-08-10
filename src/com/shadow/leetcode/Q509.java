package com.shadow.leetcode;

/**
 * 509. 斐波那契数
 * 第一次刷题：2019年1月1日
 * 第二次刷题：2020年7月30日
 * 第三次刷题：2020年8月8日18:58:09
 *
 * @author yuhongzhou
 */
public class Q509 {
    /**
     * 递归
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        return fib(N - 1) + fib(N - 2);
    }


    int[] memo;

    /**
     * 递归 + 记忆化
     *
     * @param N
     * @return
     */
    public int fib2(int N) {
        memo = new int[N + 1];
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (memo[N] != 0) {
            return memo[N];
        }
        return memo[N] = fib2(N - 1) + fib2(N - 2);
    }

    /**
     * 解题思路：动态规划
     *
     * @param N
     * @return
     */
    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}

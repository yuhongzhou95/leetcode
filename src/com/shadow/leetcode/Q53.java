package com.shadow.leetcode;

import java.util.Arrays;

/**
 * 53. 最大子序和
 * 第一次刷题：2020年8月8日21:02:49
 */
public class Q53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Q53().maxSubArray(nums));
    }

    /**
     * 解题思路：动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}

package com.shadow.leetcode;

/**
 * 152. 乘积最大子数组
 * 第一次刷题：2020年8月8日21:52:33
 */
public class Q152 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(new Q152().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }
}

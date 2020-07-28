package com.shadow.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Q1 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(new Q1().twoSum(arr, 9)));
    }
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
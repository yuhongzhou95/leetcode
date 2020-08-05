package com.shadow.leetcode;

import java.util.Arrays;

/**
 * 169. 多数元素
 * 第三次刷题：2020年8月5日14:54:20
 */
public class Q169 {

    /**
     * 摩尔投票法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int target = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    target = nums[i];
                    count = 1;
                }
            }
        }
        return target;
    }

    /**
     * 解题思路：排序法
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

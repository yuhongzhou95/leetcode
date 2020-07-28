package com.shadow.leetcode;

import java.util.Arrays;

public class Q27 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 3};
        int[] arr2 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(new Q27().removeElement(arr, 3));
    }

    /**
     * 解题思路：双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
}

package com.shadow.leetcode;

import java.util.Arrays;

public class Q80 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(new Q80().removeDuplicates(nums));
    }

    /**
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int k = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            // 前一个元素、当前元素、下一个元素都不相等
            if (!(nums[i - 1] == nums[i] && nums[i] == nums[i + 1])) {
                nums[k++] = nums[i];
            }
        }
        nums[k++] = nums[nums.length - 1];
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public int removeDuplicates2(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}

package com.shadow.leetcode;

import java.util.Arrays;

public class Q75 {
    public static void main(String[] args) {
        int[] nums = new int[]{2};
        new Q75().sortColors3(nums);
//        int i = 2;
//        int k = 2;
//        System.out.println(i ^k);
//        i = i ^ k;
//        k = i ^ k;
//        i = i ^ k;
//        System.out.println(i + "-" + k);
    }

    /**
     * 解题思路：冒泡排序
     * 时间复杂度：O(n*n)
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 计数排序：适用于元素个数非常有限的情况
     * 迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 时间复杂度：O(n)
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 解题思路：三路快速排序
     *
     * @param nums
     */
    public void sortColors3(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int j = -1;
        int k = nums.length;
        for (int i = 0; i < k; ) {
            if (nums[i] == 0) {
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // 数组是存的是引用不能使用位运算
//                nums[i] = nums[i] ^ nums[j];
//                nums[j] = nums[i] ^ nums[j];
//                nums[i] = nums[i] ^ nums[j];
                i++;
            } else if (nums[i] == 2) {
                k--;
                // 数组是存的是引用不能使用位运算
//                nums[i] = nums[i] ^ nums[k];
//                nums[k] = nums[i] ^ nums[k];
//                nums[i] = nums[i] ^ nums[k];
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

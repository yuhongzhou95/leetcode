package com.shadow.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Q283 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        new Q283().moveZeroes3(nums);
    }

    /**
     * 解题思路：使用冒泡排序，把0冒泡到数组的末尾
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] == 0) {
                    swap(nums,j,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    /**
     * 解题思路：双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 把非0元素往前挪
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        // 遍历完，后面补0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 解题思路：双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 非0元素交换位置
            if (nums[i] != 0) {
                if(i != j){
                    nums[i] = nums[j] ^ nums[i];
                    nums[j] = nums[j] ^ nums[i];
                    nums[i] = nums[j] ^ nums[i];
                }
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }


}

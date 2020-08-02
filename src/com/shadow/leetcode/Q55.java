package com.shadow.leetcode;

/**
 * 55. 跳跃游戏
 * 第一次刷题：2020年8月2日21:06:26
 */
public class Q55 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        new Q55().canJump(nums);
    }

    /**
     * 解题思路：贪心算法 从后往前遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }

    /**
     * 解题思路：从前往后遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}

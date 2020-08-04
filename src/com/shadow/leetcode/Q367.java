package com.shadow.leetcode;

/**
 * 367. 有效的完全平方数
 * 第一次刷题：2020年8月4日15:51:47
 */
public class Q367 {
    public static void main(String[] args) {
        System.out.println(new Q367().isPerfectSquare(104976));
    }

    /**
     * 解题思路：二分查找
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    /**
     * 解题思路：牛顿迭代法
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}

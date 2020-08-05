package com.shadow.leetcode;

/**
 * 69. x 的平方根
 * 第一次刷题：2020年8月4日14:45:29
 */
public class Q69 {

    /**
     * 解题思路：二分查找
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 解题思路：牛顿迭代法
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }
}

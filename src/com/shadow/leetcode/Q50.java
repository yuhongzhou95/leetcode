package com.shadow.leetcode;

/**
 * Pow(x, n)
 */
public class Q50 {

    public static void main(String[] args) {
        System.out.println(new Q50().myPow(2.0, 10));
    }

    /**
     * 采用分治的思想
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

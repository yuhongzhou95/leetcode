package com.shadow.leetcode;

/**
 * 1534. 统计好三元组
 * 刷题时间：2020年8月5日17:17:03
 */
public class Q1534 {


    /**
     * 时间复杂度：O(n*n*n)
     * 空间复杂度：O(1)
     *
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

package com.shadow.leetcode;

/**
 * 122. 买卖股票的最佳时机 II
 * 第一次刷题时间：2020年8月2日20:14:11
 */
public class Q122 {
    /**
     * 解题思路：贪心算法
     * 时间复杂度：O(n)O(n)，遍历一次。
     * 空间复杂度：O(1)O(1)，需要常量的空间。
     * 每天跟前一天相比进行比较，如果股价有上升（严格上升），就将升高的股价（ prices[i] - prices[i- 1] ）记入总利润，按照这种算法，得到的结果就是符合题意的最大利润。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}

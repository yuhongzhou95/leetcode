package com.shadow.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

/**
 * 322. 零钱兑换
 * 第一次刷题：2020年8月2日15:59:51
 */
public class Q322 {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(new Q322().coinChange(coins, 100));
    }

    /**
     * 解题思路：DFS+贪心+剪枝
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 1;
        for (int coin : coins) {
            int surplus = amount - coin;
            if (surplus == 0) {
                return count;
            } else if (surplus > 0) {
                queue.offer(surplus);
            }
        }
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            count++;
            for (int i = 0; i < currentSize; i++) {
                Integer currentAmount = queue.poll();
                for (int coin : coins) {
                    int surplus = currentAmount - coin;
                    if (surplus == 0) {
                        return count;
                    } else if (surplus > 0) {
                        queue.offer(surplus);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 解题思路：DFS+贪心+剪枝
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount < 0) {
            return 0;
        }
        return helper(coins, amount, new int[amount]);
    }

    /**
     * @param coins
     * @param amount
     * @param count
     */
    private int helper(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = helper(coins, amount - coin, count);
            if (result >= 0 && result < min) {
                min = 1 + result;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }
}

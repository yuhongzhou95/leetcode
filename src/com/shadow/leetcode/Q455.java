package com.shadow.leetcode;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 第一次刷题：2020年8月2日20:02:04
 */
public class Q455 {

    /**
     * 解题思路：贪心算法
     *
     * @param g children
     * @param s cookies
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}

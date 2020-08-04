package com.shadow.leetcode;

/**
 * 415. 字符串相加
 * 第一次刷题：2020年8月4日12:08:44
 */
public class Q415 {
    /**
     * 解题思路：
     * 时间复杂度：O(max(len1​,len2​))
     * 空间复杂度：O(n) 用了一个StringBuilder
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        // 是否进位
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}

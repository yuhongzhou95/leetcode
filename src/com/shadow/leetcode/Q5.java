package com.shadow.leetcode;

public class Q5 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Q5().longestPalindrome(s));
    }

    /**
     * 解题思路：暴力法
     * 时间复杂度：O(n*n*n)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("字符串不能为null");
        }
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLength = 1;
        int beginIndex = 0;
        char[] arrs = s.toCharArray();

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxLength && isPalindrome(arrs, i, j)) {
                    maxLength = j - i + 1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLength);
    }

    private boolean isPalindrome(char[] chars, int i, int j) {
        while (j > i) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }
}

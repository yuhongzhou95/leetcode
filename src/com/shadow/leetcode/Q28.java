package com.shadow.leetcode;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * 
 * @author yuhongzhou
 *
 */
public class Q28 {
    /**
     * 暴力匹配算法
     * 
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        if (needle.equals("")) {
            return 0;
        }
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * kmp算法
     * 
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        return -1;
    }

    public static void main(String[] args) {
        Q28 q28 = new Q28();
        String haystack = "abcde";
        String needle = "";
        int index = q28.strStr(haystack, needle);
        System.out.println(index);

    }
}

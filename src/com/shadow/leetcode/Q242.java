package com.shadow.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 */
public class Q242 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new Q242().isAnagram(s, t));
    }

    /**
     * 方法一：使用散列表
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer i = map.get(c);
            i = i == null ? 1 : ++i;
            map.put(c, i);
        }
        for (Character c : t.toCharArray()) {
            Integer i = map.get(c);
            if (i == null || i == 0) {
                return false;
            }
            map.put(c, --i);
        }
        return true;
    }

    /**
     * 方法二：使用排序
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return sChars.equals(tChars);
    }

    /**
     * 方法3：使用一个数组
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }
        for (int letter : letters) {
            if (letter != 0) {
                return false;
            }
        }
        return true;
    }
}

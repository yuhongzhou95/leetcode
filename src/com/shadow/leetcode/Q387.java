package com.shadow.leetcode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class Q387 {
    public static void main(String[] args) {
        System.out.println(new Q387().firstUniqChar("lleetcode"));
    }

    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>(32);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) == null ? 1 : map.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)).equals(1)) {
                return i;
            }
        }
        return -1;
    }
}



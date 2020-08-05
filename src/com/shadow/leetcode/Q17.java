package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 第一次刷题：2020年8月5日11:45:03
 */
public class Q17 {
    public static void main(String[] args) {
        System.out.println(new Q17().letterCombinations("23"));
    }

    /**
     * 解题思路：回溯算法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backTrack(list, digits, map, 0, new StringBuilder());
        return list;
    }

    private void backTrack(List<String> list, String digits, Map<Character, String> map, int index, StringBuilder sb) {

        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String value = map.get(digits.charAt(index));
        for (int j = 0; j < value.length(); j++) {

            backTrack(list, digits, map, index + 1, sb.append(value.charAt(j)));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

package com.shadow.leetcode;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 */
public class Q49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Q49().groupAnagrams2(strs));
    }

    /**
     * 方法一：使用散列表
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = Arrays.toString(chars);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList<String>());
            }
            map.get(sortStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 使用散列表+排序代码优化
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 排序
            char[] ca = new char[26];
            for (char c : str.toCharArray()) {
                ca[c - 'a']++;
            }
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

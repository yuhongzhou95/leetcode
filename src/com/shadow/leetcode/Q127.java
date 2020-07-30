package com.shadow.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. 单词接龙
 * 第一次刷题：2020年7月30日17:00:11
 */
public class Q127 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
//        list.add("dog");
//        list.add("lot");
//        list.add("log");
        list.add("cog");
        list.add("tog");
        System.out.println(new Q127().ladderLength("hit", "cog", list));
    }

    /**
     * 解题思路： bfs 广度优先遍历
     * 使用队列+表示是否访问过的visited集合
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        // 图的广度优先遍历，必须使用队列和表示是否访问过的visited（数组，哈希表）
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 包含起点，因此初始化的时候步数为1
        wordSet.remove(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String word = queue.poll();
                char[] chars = word.toCharArray();
                // 修改每一位的字符，从a到z
                for (int j = 0; j < beginWord.length(); j++) {
                    // 一轮以后应该重置，否则结果不正确
                    char originChar = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originChar) {
                            continue;
                        }
                        chars[j] = k;
                        String mayWord = String.valueOf(chars);
                        if (wordSet.contains(mayWord)) {
                            // 最短路径
                            if (mayWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(mayWord)) {
                                queue.add(mayWord);
                                // 注意：添加到队列以后，必须马上标记为已经访问
                                visited.add(mayWord);
                            }
                        }
                    }
                    // 恢复
                    chars[j] = originChar;
                }
            }
            step++;
        }
        return 0;
    }
}

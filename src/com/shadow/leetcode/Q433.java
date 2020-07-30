package com.shadow.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 433. 最小基因变化
 * 第一次刷题：2020年7月30日15:05:51
 */
public class Q433 {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (bankSet.isEmpty() || !bankSet.contains(end)) {
            return -1;
        }
        // 队列+已访问集合
        Deque<String> queue = new ArrayDeque<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        bankSet.remove(start);

        int step = 1;
        char[] bankChars = new char[]{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                char[] wordChars = queue.poll().toCharArray();
                for (int j = 0; j < start.length(); j++) {
                    char originChar = wordChars[j];
                    for (int k = 0; k < bankChars.length; k++) {
                        if (bankChars[k] == originChar) {
                            continue;
                        }
                        wordChars[j] = bankChars[k];
                        String current = String.valueOf(wordChars);
                        if (bankSet.contains(current)) {
                            if (end.equals(current)) {
                                return step;
                            }
                            if (!visited.contains(current)) {
                                visited.add(current);
                                queue.add(current);
                            }
                        }
                    }
                    // 恢复
                    wordChars[j] = originChar;
                }
            }
            step++;
        }
        return -1;
    }
}

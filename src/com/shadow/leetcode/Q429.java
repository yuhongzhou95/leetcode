package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 */
public class Q429 {
    /**
     * 使用队列进行层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 每次出队的数量等于当前队列的数量
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 出队
                Node node = queue.poll();
                level.add(node.val);
                for (Node child : node.children) {
                    // 下一层的元素入队
                    queue.offer(child);
                }
            }
            result.add(level);
        }
        return result;
    }
}

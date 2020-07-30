package com.shadow.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层序遍历
 * 第一次刷题时间：2020年7月30日12:20:32
 */
public class Q102 {
    /**
     * 解题思路：BFS 广度优先遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resultList.add(list);
        }
        return resultList;
    }

    /**
     * 解题思路：DFS 深度优先遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        helper(root, resultList, 0);
        return resultList;
    }

    /**
     * @param node
     * @param resultList
     * @param level      层级
     */
    private void helper(TreeNode node, List<List<Integer>> resultList, int level) {
        // 递归终止条件 terminator
        if (node == null) {
            return;
        }
        // 处理当前层逻辑  process current logic
        if (level >= resultList.size()) {
            resultList.add(new ArrayList<Integer>());
        }
        resultList.get(level).add(node.val);
        // 下探到下一层 drill down
        helper(node.left, resultList, level + 1);
        helper(node.right, resultList, level + 1);

        // 清理当前层 restore current status
    }
}

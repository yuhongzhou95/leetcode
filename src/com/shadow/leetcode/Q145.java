package com.shadow.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class Q145 {
    /**
     * 采用
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                list.addFirst(cur.val);
                cur = cur.right;
            } else {
                TreeNode node = stack.pop();
                cur = node.left;
            }
        }
        return list;
    }
}

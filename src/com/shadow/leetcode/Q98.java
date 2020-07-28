package com.shadow.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 验证二叉搜索树
 */
public class Q98 {
    /**
     * 自己想到的解决方法
     * 中序遍历
     * 用一个链表来存储树的中序遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode cur = root;
        java.util.Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            //节点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left; //考虑左子树
            }
            //节点为空，就出栈
            cur = stack.pop();
            // 判断是否满足二叉搜索树
            if (!list.isEmpty()) {
                if (cur.val <= list.getLast()) {
                    return false;
                }
            }
            //当前值加入
            list.add(cur.val);
            //考虑右子树
            cur = cur.right;
        }
        return true;
    }


    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return recurse(root, null, null);
    }

    private boolean recurse(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!recurse(node.right, val, upper)) {
            return false;
        }
        if (!recurse(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        Integer inorder = null;
        TreeNode cur = root;
        java.util.Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            //节点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left; //考虑左子树
            }
            //节点为空，就出栈
            cur = stack.pop();
            // 判断是否满足二叉搜索树
            if (inorder != null && cur.val <= inorder) {
                return false;
            }
            //当前值加入
            inorder = cur.val;
            //考虑右子树
            cur = cur.right;
        }
        return true;
    }
}

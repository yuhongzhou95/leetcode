package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class Q94 {
    public static void main(String[] args) {

    }

    /**
     * 方法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：最坏情况下需要空间O(n)，平均情况为O(log n)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderRecursion(root, list);
        return list;
    }

    public void inorderRecursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderRecursion(node.left, list);
        list.add(node.val);
        inorderRecursion(node.right, list);
    }


    /**
     * 方法二：基于栈的遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            //节点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left; //考虑左子树
            }
            //节点为空，就出栈
            cur = stack.pop();
            //当前值加入
            list.add(cur.val);
            //考虑右子树
            cur = cur.right;
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
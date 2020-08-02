package com.shadow.leetcode;

/**
 * 110. 平衡二叉树
 * 第一次刷题：2020年8月2日20:32:30
 */
public class Q110 {

    Boolean isBalanced = true;

    /**
     * 解题思路：回溯
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return isBalanced;
        }
        backTrack(root);
        return isBalanced;
    }

    private int backTrack(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = backTrack(root.left);
        int right = backTrack(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }
}

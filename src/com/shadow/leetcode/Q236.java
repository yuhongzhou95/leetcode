package com.shadow.leetcode;

/**
 * 二叉树的最近公共祖先
 */
public class Q236 {
    /**
     * 解题思路：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}

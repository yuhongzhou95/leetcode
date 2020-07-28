package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历
 */
public class Q589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.empty()) {
            Node node = stack.pop();
            list.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i > -1; i--) {
                stack.push(children.get(i));
            }

        }
        return list;
    }
}

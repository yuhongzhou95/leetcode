package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历
 */
public class Q590 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if(root !=null){
            stack.push(root);
        }
        while (!stack.empty()) {
            Node cur = stack.pop();
            list.addFirst(cur.val);
            for(Node child : cur.children)
                stack.push(child);
        }
        return list;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

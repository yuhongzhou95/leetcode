package com.shadow.leetcode;

/**
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 * 
 * @author yuhongzhou
 *
 */
public class Q307 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        NumArray numArray = new NumArray(nums);
        // System.out.println(numArray);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}

class NumArray {

    private int[] nums;

    private int[] segmentTree;

    public NumArray(int[] nums) {
        if (nums.length != 0) {
            this.nums = nums;
            segmentTree = new int[4 * nums.length];
            buildSegmentTree(0, 0, nums.length - 1);
        }
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            segmentTree[treeIndex] = nums[left];
            return;
        }
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        int mid = left + (right - left) / 2;

        // 左子树
        buildSegmentTree(leftChild, left, mid);
        // 右子树
        buildSegmentTree(rightChild, mid + 1, right);
        segmentTree[treeIndex] = segmentTree[leftChild] + segmentTree[rightChild];
    }

    public int query(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryLeft >= nums.length || queryRight < 0 || queryRight >= nums.length || queryLeft > queryRight) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, nums.length - 1, queryLeft, queryRight);
    }

    private int query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft == left && queryRight == right) {
            return segmentTree[treeIndex];
        }
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        int mid = left + (right - left) / 2;

        if (queryRight <= mid) {
            return query(leftChild, left, mid, queryLeft, queryRight);
        } else if (queryLeft >= mid + 1) {
            return query(rightChild, mid + 1, right, queryLeft, queryRight);
        }

        return query(leftChild, left, mid, queryLeft, mid) + query(rightChild, mid + 1, right, mid + 1, queryRight);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void set(int index, int value) {
        if (index < 0 || index >= nums.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        nums[index] = value;
        set(0, 0, nums.length - 1, index, value);
    }

    private void set(int treeIndex, int l, int r, int index, int value) {
        if (l == r) {
            segmentTree[treeIndex] = value;
            return;
        }

        int mid = l + (r - l) / 2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, value);
        else
            // index <= mid
            set(leftTreeIndex, l, mid, index, value);

        segmentTree[treeIndex] = segmentTree[leftTreeIndex] + segmentTree[rightTreeIndex];

    }

    public int sumRange(int i, int j) {
        if (segmentTree == null)
            throw new IllegalStateException("Segment Tree is NULL");
        return query(i, j);
    }

    public void update(int i, int val) {
        if (segmentTree == null)
            throw new IllegalStateException("Segment Tree is NULL");
        this.set(i, val);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < segmentTree.length; i++) {
            res.append(segmentTree[i]);
            if (i != segmentTree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
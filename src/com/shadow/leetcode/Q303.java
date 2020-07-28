package com.shadow.leetcode;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 
 * @author yuhongzhou
 *
 */
public class Q303 {

    public static void main(String[] args) {

        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}

//class NumArray {
//
//    private int[] nums;
//
//    private int[] segmentTree;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//        segmentTree = new int[4 * nums.length];
//        buildSegmentTree(0, 0, nums.length - 1);
//    }
//
//    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
//    private int leftChild(int index) {
//        return 2 * index + 1;
//    }
//
//    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
//    private int rightChild(int index) {
//        return 2 * index + 2;
//    }
//
//    // 在treeIndex的位置创建表示区间[l...r]的线段树
//    private void buildSegmentTree(int treeIndex, int left, int right) {
//
//        if (left == right) {
//            segmentTree[treeIndex] = nums[treeIndex];
//        }
//        
//        int leftTreeIndex = leftChild(treeIndex);
//        int rightTreeIndex = rightChild(treeIndex);
//
//        // int mid = (left + right) / 2;
//        int mid = left + (right - left) / 2;
//        buildSegmentTree(leftTreeIndex, left, mid);
//        buildSegmentTree(rightTreeIndex, mid + 1, right);
//
//        segmentTree[treeIndex] = segmentTree[leftTreeIndex]+segmentTree[rightTreeIndex];
//    }
//
//    public int sumRange(int i, int j) {
//        if (i < 0 || i >= nums.length) {
//            throw new IllegalArgumentException("i is Illegal");
//        } else if (j < 0 || j >= nums.length || i > j) {
//            throw new IllegalArgumentException("j is Illegal");
//        }
//        int sum = 0;
//        for (; i <= j; i++) {
//            sum += nums[i];
//        }
//        return sum;
//    }
//}
//class NumArray {
//
//    private int[] sum; // sum[i]存储前i个元素和, sum[0] = 0
//                       // 即sum[i]存储nums[0...i-1]的和
//                       // sum(i, j) = sum[j + 1] - sum[i]
//    public NumArray(int[] nums) {
//
//        sum = new int[nums.length + 1];
//        sum[0] = 0;
//        for(int i = 1 ; i < sum.length ; i ++)
//            sum[i] = sum[i - 1] + nums[i - 1];
//    }
//
//    public int sumRange(int i, int j) {
//        return sum[j + 1] - sum[i];
//    }
//}
// 线段树可以作为第三种解决方式 
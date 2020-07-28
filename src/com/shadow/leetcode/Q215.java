package com.shadow.leetcode;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * // TODO 实现小根堆和快速选择的解题思路
 */
public class Q215 {
    int [] nums;
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int[] nums2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new Q215().findKthLargest(nums, 2));
        System.out.println(new Q215().findKthLargest2(nums, 2));
        System.out.println(new Q215().findKthLargest(nums2, 4));
        System.out.println(new Q215().findKthLargest2(nums2, 4));
    }

    /**
     * 解题思路：堆
     * 时间复杂度： O(Nlogk)
     * 空间复杂度： O(k)，用于存储堆元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }

    /**
     * 暴力：冒泡排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums[nums.length - k];
    }

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }

    /**
     * 方法二：快速选择
     * 时间复杂度：平均情况 O(N)，最坏情况 O(N^N)
     * 空间复杂度：O(1)
     * @param left
     * @param right
     * @param pivot_index
     * @return
     */
    public int partition3(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public int quickselect(int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */

        if (left == right) // If the list contains only one element,
            return this.nums[left];  // return that element

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition3(left, right, pivot_index);

        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index)
            return this.nums[k_smallest];
            // go left side
        else if (k_smallest < pivot_index)
            return quickselect(left, pivot_index - 1, k_smallest);
        // go right side
        return quickselect(pivot_index + 1, right, k_smallest);
    }

    public int findKthLargest3(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        // kth largest is (N - k)th smallest
        return quickselect(0, size - 1, size - k);
    }
}

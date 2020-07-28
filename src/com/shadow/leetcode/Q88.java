package com.shadow.leetcode;

import java.util.Arrays;

public class Q88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        new Q88().merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int j = m - 1;
        int k = n - 1;
        while (j > -1 && k > -1) {
            if (nums1[j] > nums2[k]) {
                nums1[i] = nums1[j--];
            } else {
                nums1[i] = nums2[k--];
            }
            i--;
        }
        while (j > -1) {
            nums1[i--] = nums1[j--];
        }
        while (k > -1) {
            nums1[i--] = nums2[k--];
        }
        System.out.println(Arrays.toString(nums1));
    }


}

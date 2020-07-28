package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 
 * @author yuhongzhou
 *
 */
public class Q4 {

    public static void main(String[] args) {
//        int[] nums1 = new int[] { 1, 3 };
//        int[] nums2 = new int[] { 2 };
//        Q4 q = new Q4();
//        double result = q.findMedianSortedArrays(nums1, nums2);
//        System.out.println(result);
        Map<String,String> map = new HashMap<>();
        String str = map.get("jvm");
        System.out.println(str);
        System.out.println(str.equals("jvm"));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double a = 0.0, b = 0.0;
        if (nums1.length == 0) {
            a = 0.0;
        } else if (nums1.length == 1) {
            a = nums1[0];
        } else if (nums1.length % 2 == 0) {
            a = (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2;
        } else if (nums1.length % 2 == 1) {
            a = nums1[nums1.length / 2];
        }

        if (nums2.length == 0) {
            b = 0.0;
        } else if (nums2.length == 1) {
            b = nums2[0];
        } else if (nums2.length % 2 == 0) {
            b = (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2;
        } else if (nums2.length % 2 == 1) {
            b = nums2[nums2.length / 2];
        }
        List<Integer> list = new ArrayList<>();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Integer integer = (Integer) iterator.next();
            
        }
        return (a + b) / 2;
    }

}

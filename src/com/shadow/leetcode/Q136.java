package com.shadow.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 
 * @author yuhongzhou
 *
 */
public class Q136 {

    public static void main(String[] args) {
        Q136 q136 = new Q136();
        int[] nums = new int[]{2,2,1};
        int[] nums2 = new int[]{4,1,2,1,2};
//        System.out.println(q136.singleNumber(nums));
        System.out.println(q136.singleNumber(nums2));
    }
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        stack.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(!stack.isEmpty()){
                Integer peek = stack.peek();
                if(peek.equals(nums[i])){
                    stack.pop();
                }else{
                    stack.push(nums[i]);
                }  
            }else{
                stack.push(nums[i]);
            }
        }
        return stack.pop();
    }
}

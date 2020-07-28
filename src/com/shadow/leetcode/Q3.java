package com.shadow.leetcode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class Q3 {
    public static void main(String[] args) {
        System.out.println(new Q3().findRepeatNumber(new int[]{9, 3, 1, 0, 2, 5, 3}));
    }

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else{
                return nums[i];
            }

        }
        throw new IllegalArgumentException("找不到重复的数字");
    }
}

package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 第二次刷题：2020年8月4日21:34:04
 */
public class Q78 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Q78().subsets(nums));
    }

    /**
     * 解题思路：回溯（dfs）
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList(), nums, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        // 不选
        backtrack(resultList, list, nums, index + 1);
        // 选
        list.add(nums[index]);
        backtrack(resultList, list, nums, index + 1);
        // 恢复状态
        list.remove(list.size() - 1);
    }
}

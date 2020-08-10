package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 第一次刷题：2020年7月20日
 * 第二次刷题：2020年8月10日09:20:42
 */
public class Q47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(new Q47().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        backtrack(resultList, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // i>0是为了保证nums[i-1]有意义
            // 为了防止相同的元素在回退的时候再次被选择上
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtrack(resultList, list, nums, used);
            // 回溯
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

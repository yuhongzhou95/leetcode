package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(new Q47().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
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
            // i>0是为了保证nums[i-1]有意义
            // used[i-1]是因为在回退的过程中刚刚被撤销选择
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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

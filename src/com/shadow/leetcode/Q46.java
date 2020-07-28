package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Q46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new Q46().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<Integer>(), nums);
        return resultList;
    }

    /**
     * 回溯
     *
     * @param resultList
     * @param list
     * @param nums
     */
    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            resultList.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            backtrack(resultList, list, nums);
            list.remove(list.size() - 1);
        }
    }


}

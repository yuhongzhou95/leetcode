package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 第一次刷题：2020年8月7日10:54:44
 */
public class Q40 {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(new Q40().combinationSum2(candidates, 8));

    }

    /**
     * 解题思路：回溯算法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(resultList, new ArrayList<Integer>(), candidates, target, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            // 去重
            // 当前层循环不能使用相同的值，但是下一层循环可以使用
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tmp.add(candidates[i]);
            backtrack(res, tmp, candidates, target - candidates[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

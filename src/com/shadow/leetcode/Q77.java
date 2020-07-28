package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */
public class Q77 {

    public static void main(String[] args) {
        List<List<Integer>> combine = new Q77().combine(5, 2);
        System.out.println(combine);
    }


    /**
     * 解题思路：回溯+剪枝
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<Integer>(), 1, n, k);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, List<Integer> list, int begin, int n, int k) {
        if (k == 0) {
            resultList.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = begin; i <= n; i++) {
            list.add(i);
            backtrack(resultList, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}

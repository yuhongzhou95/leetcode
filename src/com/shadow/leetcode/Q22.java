package com.shadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 第四次刷题时间：2020年7月30日14:42:02
 * 第一次刷题时间：2020年7月20日
 * 第二次刷题时间：2020年7月10日
 * 第三次刷题时间：2020年7月8日
 */
public class Q22 {
    public static void main(String[] args) {
        List<String> result = new Q22().generateParenthesis(0);
        System.out.println(result);
    }

    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        helper(0, 0, n, "");
        return result;
    }

    private void helper(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            helper(left + 1, right, n, s + "(");
        }
        if (right < left) {
            helper(left, right + 1, n, s + ")");
        }
    }
}

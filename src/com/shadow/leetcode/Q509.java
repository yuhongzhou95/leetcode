package com.shadow.leetcode;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * 
 * @author yuhongzhou
 *
 */
public class Q509 {
    public int fib(int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        return fib(N - 1) + fib(N - 2);
    }
}

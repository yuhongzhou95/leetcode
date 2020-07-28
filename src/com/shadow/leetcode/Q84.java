package com.shadow.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 */
public class Q84 {
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(new Q84().largestRectangleArea2(heights));
    }

    /**
     * 方法一：暴力
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(1)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // 枚举左边界
        for (int left = 0; left < heights.length; left++) {
            int minHeight = Integer.MAX_VALUE;
            // 枚举右边界
            for (int right = left; right < heights.length; right++) {
                // 确定高度
                minHeight = Math.min(minHeight, heights[right]);
                // 计算面积
                maxArea = Math.max(maxArea, (right - left + 1) * minHeight);
            }
        }
        return maxArea;
    }

    /**
     * 方法二：使用栈
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            // 栈不为空，并且栈顶元素小于准备入栈的元素，开始出栈
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                // 处理高度相同的
                while (!stack.isEmpty() && heights[stack.peek()] == height) {
                    stack.pop();
                }
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            while (!stack.isEmpty() && heights[stack.peek()] == height) {
                stack.pop();
            }
            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peek() - 1;
            }
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }
}

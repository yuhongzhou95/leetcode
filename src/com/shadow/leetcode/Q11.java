package com.shadow.leetcode;

public class Q11 {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Q11().maxArea2(height));
    }

    /**
     * 暴力解法
     * 时间复杂度：O(n*n)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = height.length - 1; j > 0; j--) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * 双指针
     * 时间复杂度O(n)
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area;
            if (height[i] > height[j]) {
                area = (j - i) * height[j];
                j--;
            } else {
                area = (j - i) * height[i];
                i++;
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}

package com.shadow;

/**
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        int[] nums2 = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            nums2[i] = i+1;
        }
        System.out.println(nums2[499999]);
        System.out.println(new BinarySearch().binarySearch(nums2, 1));
    }

    /**
     * @param nums   数组
     * @param target 目标数
     * @return 数组下标
     */
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println(mid+":"+nums[mid]);
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

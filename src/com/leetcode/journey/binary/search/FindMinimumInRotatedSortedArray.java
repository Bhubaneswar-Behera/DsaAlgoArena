package com.leetcode.journey.binary.search;

/**
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums)); // Output: 0
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half or at mid
                right = mid;
            }
        }

        // Left and right converge to the minimum element
        return nums[left];
    }
}

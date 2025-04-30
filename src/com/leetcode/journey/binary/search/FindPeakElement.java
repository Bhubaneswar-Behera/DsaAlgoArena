package com.leetcode.journey.binary.search;

/**
 *
 * https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums)); // Output: 2
    }

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is in the left half (including mid)
                right = mid;
            } else {
                // Peak is in the right half
                left = mid + 1;
            }
        }

        // Left and right converge to the peak element
        return left;
    }
}

package com.neetcode150.binary.search;

/**
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * Reference : https://www.youtube.com/watch?v=6WNZQBHWQJs
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target)); // Output: 4
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            //either left to mid is sorted or mid to right is sorted
            if (nums[left] <= nums[mid]) { // left to mid is sorted
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1; // target is in the left sorted part
                } else {
                    left = mid + 1; // target is in the right part
                }
            } else { // mid to right is sorted
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1; // target is in the right sorted part
                } else {
                    right = mid - 1; // target is in the left part
                }
            }
        }
        return -1;
    }
}

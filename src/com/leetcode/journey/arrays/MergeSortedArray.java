package com.leetcode.journey.arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // Pointer for nums1
        int p2 = n - 1; // Pointer for nums2
        int resultArray = m + n - 1; // Pointer for the merged array

        // Merge nums1 and nums2 from the end in the nums1 array
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[resultArray] = nums1[p1];
                p1--;
            } else {
                nums1[resultArray] = nums2[p2];
                p2--;
            }
            resultArray--;// reduce the pointer for the merged array
        }

        // Copy remaining elements from nums2, if any
        while (p2 >= 0) {
            nums1[resultArray] = nums2[p2];
            p2--;
            resultArray--;
        }
    }
}

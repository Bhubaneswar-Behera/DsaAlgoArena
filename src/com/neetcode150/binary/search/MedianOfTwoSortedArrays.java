package com.neetcode150.binary.search;

import java.util.Arrays;

/**
 *
 * https://neetcode.io/problems/median-of-two-sorted-arrays
 * Reference : https://www.youtube.com/watch?v=WQ1STBnmx2w
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int [] nums1 = {1, 3,8,17};
        int [] nums2 = {5,6,7,19,21,25};
        //System.out.println(findMedianSortedArraysBruteForce(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    //Time Complexity: O(m+n)) where m and n are the lengths of the two arrays.
    public static double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] merged = new int[len1 + len2];
        System.arraycopy(nums1, 0, merged, 0, len1);
        System.arraycopy(nums2, 0, merged, len1, len2);
        Arrays.sort(merged);

        int totalLen = merged.length;
        if (totalLen % 2 == 0) {
            return (merged[totalLen / 2 - 1] + merged[totalLen / 2]) / 2.0;
        } else {
            return merged[totalLen / 2];
        }
    }

    // Time Complexity: O(log(min(m, n))) where m and n are the lengths of the two arrays.
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if(arr2.length < arr1.length) {
            return findMedianSortedArrays(arr2, arr1);
        }
        int low = 0;
        int high = arr1.length;

        while (low <= high ){
            int mid1 = low + (high - low) / 2;
            int mid2 = (arr1.length + arr2.length + 1) / 2 - mid1;//+1 as it works for odd and even
            // if mid1 is 0, it means there are no elements on the left side of arr1
            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];

            // if mid1 is equal to the length of arr1, it means there are no elements on the right side of arr1
            int right1 = (mid1 == arr1.length) ? Integer.MAX_VALUE : arr1[mid1];

            // if mid2 is 0, it means there are no elements on the left side of arr2
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];

            // if mid2 is equal to the length of arr2, it means there are no elements on the right side of arr2
            int right2 = (mid2 == arr2.length) ? Integer.MAX_VALUE : arr2[mid2];

            if(left1 <= right2 && left2 <= right1) {
                // Found the partition
                if((arr1.length + arr2.length) % 2 == 0) {
                    return (float)(Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return (float)(Math.max(left1, left2));
                }
            } else if (left2 > right1) {
                low = mid1 + 1;
            } else {
                high = mid1 - 1;
            }
        }
        return 0.0f; // This line should never be reached if the input arrays are valid
    }
}

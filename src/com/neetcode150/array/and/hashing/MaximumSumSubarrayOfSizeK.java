package com.neetcode150.array.and.hashing;

/**
 *
 * Given an integer array nums and an integer k,
 * find the maximum sum (or average) of a contiguous subarray of length k.
 *
 * Example:
 * Input : nums = [2,1,5,1,3,2] , k = 3
 * Output: 9
 * Explanation:
 * [2,1,5] = 8
 * [1,5,1] = 7
 * [5,1,3] = 9   ← maximum
 * [1,3,2] = 6
 * [3,2] = 5
 * So Maximum sum = 9
 */
public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] nums = {2,1,5,1,3,2};
        int k = 3;
        int result = maxSubarraySum(nums, k);
        int resultOptimized = maxSubarraySumOptimized(nums, k);
        System.out.println("Maximum subarray sum of size " + k + " is: " + result);
        System.out.println("Maximum subarray sum of size " + k + " is: " + resultOptimized);
    }

    /**
     * Time Complexity: O(n * k)
     * Space Complexity: O(1)
     */
    public static int maxSubarraySum(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for(int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxSubarraySumOptimized(int[] nums, int k) {
        int windowSum = 0;
        int maxSum;

        // Step 1: first window
        for(int i = 0; i < k; i++) {
            windowSum = windowSum + nums[i];
        }

        maxSum = windowSum;

        // Step 2: slide window
        for(int i = k; i < nums.length; i++) {

            windowSum = windowSum + nums[i];       // add new element
            windowSum = windowSum - nums[i - k];   // remove old element

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}

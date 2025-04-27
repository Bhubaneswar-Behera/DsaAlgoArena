package com.leetcode.journey.arrays;

/**
 *
 * https://leetcode.com/problems/maximum-sum-circular-subarray/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Reference : Kadane's Algorithm
 */
public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {
            // Calculate max subarray sum using Kadane's algorithm
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            // Calculate min subarray sum using Kadane's algorithm
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);

            // Calculate total sum of the array
            totalSum += num;
        }

        // If all elements are negative, maxSum is the result
        if (totalSum == minSum) {
            return maxSum;
        }

        // Return the maximum of non-circular and circular cases
        return Math.max(maxSum, totalSum - minSum);
    }
}

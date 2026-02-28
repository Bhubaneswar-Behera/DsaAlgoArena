package com.neetcode150.array.and.hashing;

/**
 *
 * https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
 * maxSubarraySum or Kadanes Algorithm
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaxSubarraySumOrKadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        int result = maxSubarraySum(arr);
        System.out.println("Maximum subarray sum is: " + result);
    }

    public static int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < n ; i++) {
            currentSum = currentSum + arr[i];
            //If the current running sum is greater than previous max, update it.
            maxSum = Math.max(maxSum, currentSum);
            //If the current running sum is less than 0, reset it to 0.
            if (currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;

    }
}

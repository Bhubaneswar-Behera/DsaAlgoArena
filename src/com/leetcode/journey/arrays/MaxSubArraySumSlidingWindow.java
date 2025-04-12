package com.leetcode.journey.arrays;

/**
 * Given arr[n], print max subarray sum of
 * all subarrays of length k. [1<= k <= n]
 *
 */
public class MaxSubArraySumSlidingWindow {
    public static void main(String[] args) {
        int[] A = {-3,4,-2,5,3,-2,8,2,-1,4};
        int k = 5;
        System.out.println(maxSumSubArraySlidingWindow(A,k));
    }
    public static int maxSumSubArraySlidingWindow(int[] arr, int k){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < k ; i++) {
            sum = sum + arr[i];
        }
        maxSum = sum;

        for (int i = 1; i < n - k ; i++) {//iterate from 1 to n-k
        int j = i + k -1; //the new element entering the window
        sum = sum + arr[j] - arr[i-1]; //remove the first element of the previous window
        maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}

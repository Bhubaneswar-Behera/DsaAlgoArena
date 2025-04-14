package com.leetcode.journey.arrays;

/**
 * Given an integer Array[n] , find the maximum subarrray sum
 * out of all subarrays.
 *
 * Ex:
 * Input : A {-2,3,4,-1,5,-10,7}
 * OutPut: maxSum = 11
 * Explanation : 3+4+(-1)+5 = 11
 *
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -10};
        int n = arr.length;
        System.out.println(maxSumSubArrayBruteForce(arr,n));
        System.out.println(maxSumSubArrayCarryForward(arr,n));
        System.out.println(maxSumKadanesAlgorithm(arr,n));
    }
    public static int maxSumSubArrayBruteForce(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n ; j++) {
                int currentSum = 0;
                for (int k = i; k < j ; k++) {
                 currentSum = currentSum + arr[k];
                }
                maxSum = Math.max(maxSum,currentSum);
            }
        }
        return maxSum;
    }
    public static int maxSumSubArrayCarryForward(int[] arr,int n){
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n ; i++) {
           int currentSum = 0;
            for (int j = i; j < n ; j++) {
                currentSum =currentSum + arr[j];
                maxSum = Math.max(maxSum,currentSum);
            }
        }
        return maxSum;
    }
    public static int maxSumKadanesAlgorithm(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < n ; i++) {
            currentSum = currentSum + arr[i];
            if (currentSum > maxSum){
                maxSum = currentSum;
            }
            if (currentSum < 0){
                currentSum = 0;
            }
        }

        return maxSum;
    }
}

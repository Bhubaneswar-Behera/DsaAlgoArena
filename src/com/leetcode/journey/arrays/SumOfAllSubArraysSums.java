package com.leetcode.journey.arrays;

/**
 * Given arr[n], find the sum of total of all the possible subarrays.
 * (Sum of all subarray sums)
 *
 * Note : Be careful of integer overflow issues while calculations.
 * Use appropriate datatypes.
 * Example Input : A = [1, 2, 3]
 * Output : 20
 *
 * Explanation : The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
 * Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20
 */

public class SumOfAllSubArraysSums {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        System.out.println(calculateSumBruteForce(arr, n));
        System.out.println(calculateSumCarryForward(arr, n));
        System.out.println(calculateSumContributionTechnique(arr, n));
    }
    /**
     * Brute force approach
     * Time complexity : O(n^3)
     * Space complexity : O(1)
     */
    public static int calculateSumBruteForce(int[] arr, int n){
        int totalSum = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n ; j++) {
                int sum = 0;
                for (int k = i; k <= j ; k++) {
                    sum = sum +  arr[k];
                }
                totalSum = totalSum + sum;
            }
        }
        return totalSum;
    }
    public static int calculateSumCarryForward(int[] arr, int n){
        int totalSum = 0;
        for (int i = 0; i < n ; i++) {
            int sum = 0;
            for(int j = i ;j < n ;j++){
                sum = sum +  arr[j];
                totalSum = totalSum + sum;
            }
        }

        return totalSum;
    }
    public static int calculateSumContributionTechnique(int[] arr,int n){
        int totalSum = 0;
        for (int i = 0; i < n ; i++) {
            totalSum = totalSum + arr[i] * (i+1) * (n-i);
        }

        return totalSum;
    }
}

package com.leetcode.journey.arrays;

/**
 * Given an array of integers, and queries q with start(s) and end(e) indices.
 * For each query, find the sum of the elements at odd indices between s and e (inclusive).
 *
 * Example:
 * Input : A --> {2,3,1,6,4,5}
 * Queries :
 * s  e
 * 1  3  --> 3 + 6 = 9
 * 2  5  --> 6 + 5 = 11
 * 0  4  --> 3 + 6 = 9
 * 3  3  --> 6
 *
 */
public class OddIndexSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 4, 5};
        int[][] queries = {{1, 3}, {2, 5}, {0, 4}, {3, 4}};
        prefixSum(arr, queries);
    }
    public static void prefixSum(int[] arr, int[][] queries){
        int n = arr.length;
        int q = queries.length;
        int prefixSumArray[] = new int[n];
        prefixSumArray[0] = 0;

        for (int i = 1; i < n ; i++) {
            if (i % 2 != 0){
                prefixSumArray[i] = prefixSumArray[i - 1] + arr[i];
            } else {
                prefixSumArray[i] = prefixSumArray[i-1];
            }
        }

        for (int i = 0; i < q ; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int sum = 0;
            if(l == 0){
                sum = prefixSumArray[r];
            } else {
                sum = prefixSumArray[r] - prefixSumArray[l - 1];
            }
            System.out.println("l-->" + l + " r-->" + r + " Odd index sum : " + sum);
        }
    }
}

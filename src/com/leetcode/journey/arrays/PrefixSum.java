package com.leetcode.journey.arrays;

/**
 * Given an array of integers,
 * find the sum of the elements between two indices i and j (i ≤ j).
 * This is a common problem that can be solved using the prefix sum technique.
 *
 * Example:
 * Input: arr = [1, 2, 3, 4, 5], i = 1, j = 3
 * Output: 9
 */
public class PrefixSum {
    public static int prefixSum(int[] arr, int i, int j) {
        // Calculate the prefix sum
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int i = 1;
        int j = 3;
        System.out.println("Sum between indices " + i + " and " + j + ": " + prefixSum(arr, i, j));
    }
}

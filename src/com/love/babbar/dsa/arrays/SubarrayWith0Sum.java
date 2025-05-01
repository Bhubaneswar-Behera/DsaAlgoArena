package com.love.babbar.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://www.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
 */
public class SubarrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        System.out.println(findsum(arr)); // Output: true

        int[] arr2 = {1, 2, 3};
        System.out.println(findsum(arr2)); // Output: false
    }

    public static boolean findsum(int arr[]) {
        int n = arr.length;
        Set<Integer> prefixSumHashSet = new HashSet<>();
        int prefixSum = 0;

        for (int i = 0; i < n ; i++) {
            prefixSum = prefixSum + arr[i];
            // If prefixSum is 0 or if it is already present in the set, return true
            if(prefixSum == 0 || prefixSumHashSet.contains(prefixSum)){
                return true;
            }
            // Add the prefixSum to the set
            prefixSumHashSet.add(prefixSum);
        }
        return false;
    }
}

package com.love.babbar.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://www.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
 */
public class TripletSumInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int targetSum = 9;
        System.out.println(hasTripletSum(arr, targetSum));
    }

    public static boolean hasTripletSum(int arr[], int target) {
        // Your code Here
        Arrays.sort(arr); // Sort the array
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    return true; // Triplet found
                } else if (sum < target) {
                    left++; // Increase the sum
                } else {
                    right--; // Decrease the sum
                }
            }
        }

        return false; // No triplet found
    }

    public static boolean hasTripletSumHashMapApproach(int[] arr, int target) {
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            int currentTarget = target - arr[i];
            if (twoSum(arr, i + 1, n, currentTarget)) {
                return true; // Triplet found
            }
        }

        return false; // No triplet found
    }

    private static boolean twoSum(int[] arr, int start, int end, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = start; i < end; i++) {
            int delta = target - arr[i];
            if (map.containsKey(delta)) {
                return true; // Pair found
            }
            map.put(arr[i], i);
        }

        return false; // No pair found
    }
}

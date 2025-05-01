package com.love.babbar.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 */
public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        int k = 5;
        ArrayList<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(findMinDiff(list, k));
    }
    public static int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        if (m == 0 || arr.size() == 0) {
            return 0; // No students or no packets
        }

        if (arr.size() < m) {
            return -1; // Not enough packets for students
        }

        // Sort the array
        Collections.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        // Find the minimum difference in subarrays of size m
        for (int i = 0; i + m - 1 < arr.size(); i++) {
            int diff = arr.get(i + m - 1) - arr.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;

    }
}

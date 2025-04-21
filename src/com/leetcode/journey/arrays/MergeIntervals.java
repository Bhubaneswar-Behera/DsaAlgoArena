package com.leetcode.journey.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);

        // Print the result
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Merge intervals
        for (int[] interval : intervals) {
            // If the list is empty or the current interval does not overlap with the last one
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlapping intervals, merge them
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Step 3: Convert the list to an array and return
        return merged.toArray(new int[merged.size()][]);
    }
}

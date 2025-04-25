package com.leetcode.journey.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *https://leetcode.com/problems/insert-interval/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = insert(intervals, newInterval);

        // Print the result
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add all intervals that end before the new interval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with the new interval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add all intervals that start after the new interval ends
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the result list to an array and return
        return result.toArray(new int[result.size()][]);
    }
}

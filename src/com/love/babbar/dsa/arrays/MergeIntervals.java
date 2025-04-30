package com.love.babbar.dsa.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {17, 20}};
        int[][] mergedIntervals = merge(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        //Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < n; i++) {
            // Get the current interval
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Get the top interval from the stack
            int[] topOfTheStackArray = stack.pop();

            int topOfTheStackStart = topOfTheStackArray[0];
            int topOfTheStackEnd = topOfTheStackArray[1];

            //calculate the max end
            int maxEnd = Math.max(topOfTheStackEnd, currentEnd);

            // Check if the intervals overlap
            if (currentStart <= topOfTheStackEnd) {
                // Merge intervals
                int[] mergedInterval = new int[]{topOfTheStackStart,maxEnd};
               stack.push(mergedInterval);
            } else {
                // Push the old and new interval back to the stack
                stack.push(topOfTheStackArray);
                stack.push(intervals[i]);
            }
        }

        // Convert the stack to an output array
        int[][] output = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            output[i] = stack.pop();
        }
        return output;
    }
}

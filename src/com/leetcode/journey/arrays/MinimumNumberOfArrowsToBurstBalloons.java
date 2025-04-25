package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Minimum number of arrows: " + findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Step 1: Sort the balloons by their ending coordinates
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // At least one arrow is needed
        int lastArrowPosition = points[0][1]; // Position of the first arrow

        // Step 2: Iterate through the balloons
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow position, shoot a new arrow
            if (points[i][0] > lastArrowPosition) {
                arrows++;
                lastArrowPosition = points[i][1]; // Update the position of the new arrow
            }
        }

        return arrows;
    }
}

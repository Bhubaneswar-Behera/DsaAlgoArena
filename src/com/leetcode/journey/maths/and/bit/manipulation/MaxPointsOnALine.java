package com.leetcode.journey.maths.and.bit.manipulation;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxPointsOnALine {
    public static void main(String[] args) {
        MaxPointsOnALine solution = new MaxPointsOnALine();

        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println("Input: points = [[1,1],[2,2],[3,3]], Output: " + solution.maxPoints(points1)); // Expected: 3

        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println("Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]], Output: " + solution.maxPoints(points2)); // Expected: 4
    }

    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length; // If there are 2 or fewer points, all are on the same line
        }

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 1; // Count the point itself
            int localMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicate++; // Count duplicate points
                    continue;
                }

                int gcd = gcd(dx, dy); // Simplify the slope
                dx /= gcd;
                dy /= gcd;

                // Use a string representation of the slope as the key
                String slope = dx + "/" + dy;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(slope));
            }

            maxPoints = Math.max(maxPoints, localMax + duplicate);
        }

        return maxPoints;
    }

    // Helper method to calculate the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

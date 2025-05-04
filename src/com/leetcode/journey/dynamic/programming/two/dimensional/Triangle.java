package com.leetcode.journey.dynamic.programming.two.dimensional;

import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/triangle/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Triangle {

    public static void main(String[] args) {
        Triangle triangleSolver = new Triangle();
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        System.out.println(triangleSolver.minimumTotal(triangle)); // Output: 11
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Start from the second-to-last row and move upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                // Update the current element to the minimum path sum
                int current = triangle.get(row).get(col);
                int below = triangle.get(row + 1).get(col);
                int belowRight = triangle.get(row + 1).get(col + 1);
                triangle.get(row).set(col, current + Math.min(below, belowRight));
            }
        }

        // The top element contains the minimum path sum
        return triangle.get(0).get(0);
    }
}

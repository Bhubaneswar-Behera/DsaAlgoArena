package com.leetcode.journey.dynamic.programming.two.dimensional;

/**
 *
 * https://leetcode.com/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum solver = new MinimumPathSum();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solver.minPathSum(grid)); // Output: 7
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Iterate through the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Starting point, no change
                    continue;
                } else if (i == 0) {
                    // First row, can only come from the left
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    // First column, can only come from above
                    grid[i][j] += grid[i - 1][j];
                } else {
                    // Take the minimum of top and left cells
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        // Return the value at the bottom-right corner
        return grid[m - 1][n - 1];
    }
}

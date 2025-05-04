package com.leetcode.journey.dynamic.programming.two.dimensional;

/**
 *
 * https://leetcode.com/problems/unique-paths-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class UniquePathsII {

    public static void main(String[] args) {
        UniquePathsII solver = new UniquePathsII();
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(solver.uniquePathsWithObstacles(obstacleGrid)); // Output: 2
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the starting or ending cell is an obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // Create a DP array
        int[][] dp = new int[m][n];

        // Initialize the starting point
        dp[0][0] = 1;

        // Fill the DP array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // No paths through an obstacle
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j]; // Paths from the top
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1]; // Paths from the left
                    }
                }
            }
        }

        // Return the number of unique paths to the bottom-right corner
        return dp[m - 1][n - 1];
    }
}

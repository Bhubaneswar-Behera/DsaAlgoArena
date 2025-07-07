package com.neetcode150.graph;

/**
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 0}
        };
        System.out.println("Max area of island: " + maxAreaOfIsland(grid)); // Output: 5
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
    private static int dfs(int[][] grid, int i, int j) {
        // Check for out of bounds and if the cell is water (0)
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // Mark the cell as visited
        grid[i][j] = 0;

        // Explore all four directions and sum the area
        return 1 + dfs(grid, i + 1, j) // down
                + dfs(grid, i - 1, j) // up
                + dfs(grid, i, j + 1) // right
                + dfs(grid, i, j - 1); // left
    }
}

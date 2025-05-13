package com.graph.learning.part1;

/**
 *
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println("Number of islands: " + numIslands(grid)); // Output: 3
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // Mark the cell as visited

        // Explore all four directions
        dfs(grid, i + 1, j); //bottom
        dfs(grid, i - 1, j);//top
        dfs(grid, i, j + 1);//right
        dfs(grid, i, j - 1);//left
    }
}

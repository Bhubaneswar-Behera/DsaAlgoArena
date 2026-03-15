package com.neetcode150.graph;

/**
 *
 * https://leetcode.com/problems/number-of-islands/description/
 * Reference: https://www.youtube.com/watch?v=ZgCZfXPo3hI&t=909s
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + numIslands(grid)); // Output: 3
    }
 //Time Complexity: O(rows * cols)
 //Space Complexity: O(rows * cols)
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int row, int col) {
        // Check for out of bounds and if the cell is water ('0')
        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length
                || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; // Mark the cell as visited

        // Explore all four directions
        dfs(grid, row + 1, col); //bottom
        dfs(grid, row - 1, col);//top
        dfs(grid, row, col + 1);//right
        dfs(grid, row, col - 1);//left
    }
}

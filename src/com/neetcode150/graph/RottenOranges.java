package com.neetcode150.graph;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/rotting-oranges/description/
 *
 * Reference: https://www.youtube.com/watch?v=cYgVxX5ssoo&t=136s
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 */
public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println("Time taken to rot all oranges: " + orangesRotting(grid)); // Output: 4
    }
    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0){
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] time = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    dfs(grid, time, i, j, 0);
            }
        }
        int timeRequired = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 1) {
                    if (time[i][j] == Integer.MAX_VALUE){
                        return -1;
                    }
                    timeRequired = Math.max(timeRequired, time[i][j]);
                }

        return timeRequired;
    }

    private static void dfs(int[][] grid, int[][] time, int i, int j, int currentTime) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == 0 || currentTime >= time[i][j]) {
            return;
        }

        time[i][j] = currentTime;
        dfs(grid, time, i - 1, j, currentTime + 1);
        dfs(grid, time, i + 1, j, currentTime + 1);
        dfs(grid, time, i, j - 1, currentTime + 1);
        dfs(grid, time, i, j + 1, currentTime + 1);
    }
}

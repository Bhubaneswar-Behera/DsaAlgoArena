package com.neetcode150.graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 * Reference :
 */
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        // Example usage
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        System.out.println(solution.pacificAtlantic(heights));
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Check for empty input
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        int rowCount = heights.length;
        int colCount = heights[0].length;
        boolean[][] pacificVisited = new boolean[rowCount][colCount];
        boolean[][] atlanticVisited = new boolean[rowCount][colCount];
        // Perform DFS for Pacific Ocean (top and left edges)
        for (int i = 0; i < rowCount; i++) {
            dfs(heights, pacificVisited, i, 0); //leftmost column → touches the Pacific Ocean
            dfs(heights, atlanticVisited, i, colCount - 1); //rightmost column → touches the Atlantic Ocean
        }
        // Perform DFS for Atlantic Ocean (bottom and right edges)
        for (int j = 0; j < colCount; j++) {
            dfs(heights, pacificVisited, 0, j); //topmost row → touches the Pacific Ocean
            dfs(heights, atlanticVisited, rowCount - 1, j); //bottom row → touches the Atlantic Ocean
        }
        List<List<Integer>> result = new ArrayList<>();
        // Collect cells that can reach both oceans
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        // Down
        if (isValid(heights, visited, row, col, row + 1, col)) {
            dfs(heights, visited, row + 1, col);
        }

        // Up
        if (isValid(heights, visited, row, col, row - 1, col)) {
            dfs(heights, visited, row - 1, col);
        }

        // Right
        if (isValid(heights, visited, row, col, row, col + 1)) {
            dfs(heights, visited, row, col + 1);
        }

        // Left
        if (isValid(heights, visited, row, col, row, col - 1)) {
            dfs(heights, visited, row, col - 1);
        }
    }

    private boolean isValid(int[][] heights, boolean[][] visited, int currRow, int currCol, int newRow, int newCol) {
        int m = heights.length;
        int n = heights[0].length;

        return newRow >= 0 && newRow < m &&
                newCol >= 0 && newCol < n &&
                !visited[newRow][newCol] &&
                heights[newRow][newCol] >= heights[currRow][currCol];
    }
}

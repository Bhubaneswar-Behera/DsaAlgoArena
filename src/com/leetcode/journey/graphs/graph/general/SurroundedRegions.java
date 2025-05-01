package com.leetcode.journey.graphs.graph.general;

/**
 *
 * https://leetcode.com/problems/surrounded-regions/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solution.solve(board);

        for (char[] row : board) {
            System.out.println(new String(row));
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
        return;
    }

    int rows = board.length;
    int cols = board[0].length;

    // Step 1: Mark all 'O's connected to the boundary as safe
        for (int i = 0; i < rows; i++) {
        if (board[i][0] == 'O') {
            dfs(board, i, 0);
        }
        if (board[i][cols - 1] == 'O') {
            dfs(board, i, cols - 1);
        }
    }
        for (int j = 0; j < cols; j++) {
        if (board[0][j] == 'O') {
            dfs(board, 0, j);
        }
        if (board[rows - 1][j] == 'O') {
            dfs(board, rows - 1, j);
        }
    }

    // Step 2: Replace all 'O's with 'X's and all 'T's back to 'O's
        for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (board[i][j] == 'O') {
                board[i][j] = 'X';
            } else if (board[i][j] == 'T') {
                board[i][j] = 'O';
            }
        }
    }
}

private void dfs(char[][] board, int row, int col) {
    // Boundary check
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
        return;
    }

    // Mark the cell as safe
    board[row][col] = 'T';

    // Explore all 4 directions
    dfs(board, row - 1, col); // Up
    dfs(board, row + 1, col); // Down
    dfs(board, row, col - 1); // Left
    dfs(board, row, col + 1); // Right
}
}

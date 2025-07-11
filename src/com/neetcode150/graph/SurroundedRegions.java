package com.neetcode150.graph;

/**
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 * Reference : https://www.youtube.com/watch?v=yaBaE4fo6wA
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        SurroundedRegions solution = new SurroundedRegions();
        solution.solve(board);

        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int column = board[0].length;

        // Mark boundary-connected 'O's with 'T'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((i == 0 || i == row - 1 || j == 0 || j == column - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // Capture surrounded regions and revert 'T' to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T'; // Mark as visited
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}

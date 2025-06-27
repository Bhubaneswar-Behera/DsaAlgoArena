package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/n-queens/description/
 * Reference : https://www.youtube.com/watch?v=BdSJnIdR-4s
 */
public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // Initialize the board with '.' representing empty cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(board,  0,n,result);
        return result;
    }
    private void backtrack(char[][] board, int row,int n,  List<List<String>> result) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isValid(board,row, j, n)) {
                // Place a queen at (i, col)
                board[row][j] = 'Q';
                // Recur to place the next queen
                backtrack(board, row + 1, n , result);
                // Remove the queen from (i, col) for backtracking
                board[row][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        // Horizontal check
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        //Vertical check
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //left diagonal check
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //right diagonal check
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    // Constructs the board from the character array to a list of strings
    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            result.add(row);
        }
        return result;
    }
}

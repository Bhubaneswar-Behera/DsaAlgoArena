package com.leetcode.journey.recursion.and.backtracking;

/**
 *
 * https://leetcode.com/problems/word-search/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word)); // Output: true
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // Base case: if the entire word is found
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and if the current cell matches the word's character
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by temporarily changing its value
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all four possible directions
        boolean found = backtrack(board, word, row + 1, col, index + 1) ||
                backtrack(board, word, row - 1, col, index + 1) ||
                backtrack(board, word, row, col + 1, index + 1) ||
                backtrack(board, word, row, col - 1, index + 1);

        // Restore the cell's original value
        board[row][col] = temp;

        return found;
    }
}

package com.neetcode150.backtracking;

/**
 *
 * https://leetcode.com/problems/word-search/description/
 * Reference: https://www.youtube.com/watch?v=c9Myn-zYmJs
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word)); // Output: True
    }
    public boolean exist(char[][] board, String word) {
        int totalNoOfRows = board.length;
        int totalNoOfColumns = board[0].length;

        for (int row = 0; row < totalNoOfRows; row++) {
            for (int column = 0; column < totalNoOfColumns; column++) {
                if (backtrack(board, word, row, column, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int row, int col, int index) {

        // If we have matched all characters in the word, return true.
        if (index == word.length()) {
            return true;
        }
        // If we are out of bounds or the character does not match, return false.
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by replacing it with a special character (e.g., '#').
        char temp = board[row][col];
        board[row][col] = '#';


        // Explore all four possible directions: down, up, right, left.
        boolean found = backtrack(board, word, row + 1, col, index + 1) ||
                backtrack(board, word, row - 1, col, index + 1) ||
                backtrack(board, word, row, col + 1, index + 1) ||
                backtrack(board, word, row, col - 1, index + 1);

        // Restore the original character in the cell after exploring.
        board[row][col] = temp;

        return found;
    }
}

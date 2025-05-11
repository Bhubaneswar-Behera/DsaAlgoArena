package com.neetcode150.array.and.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://neetcode.io/problems/valid-sudoku
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board)); // Output: true
    }

    public static boolean isValidSudoku(char[][] board) {
        // Create sets to track seen numbers in rows, columns, and sub-boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Iterate through the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                // Skip empty cells
                if (num == '.') {
                    continue;
                }

                // Check row
                if (rows[i].contains(num)) {
                    return false;
                }
                rows[i].add(num);

                // Check column
                if (cols[j].contains(num)) {
                    return false;
                }
                cols[j].add(num);

                // Check 3x3 sub-box
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (boxes[boxIndex].contains(num)) {
                    return false;
                }
                boxes[boxIndex].add(num);
            }
        }
        return true;
    }
}

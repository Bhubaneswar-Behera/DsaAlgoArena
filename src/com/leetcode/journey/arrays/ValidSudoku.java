package com.leetcode.journey.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/valid-sudoku/?envType=study-plan-v2&envId=top-interview-150
 *
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
        System.out.println("Is the Sudoku board valid? " + isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[][] boxes = new HashSet[3][3];

        // Initialize sets for rows, columns, and boxes
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxes[i][j] = new HashSet<>();
            }
        }

        // Iterate through the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue; // Skip empty cells

                // Check row
                if (rows[i].contains(num)) return false;
                rows[i].add(num);

                // Check column
                if (cols[j].contains(num)) return false;
                cols[j].add(num);

                // Check 3x3 sub-box
                if (boxes[i / 3][j / 3].contains(num)) return false;
                boxes[i / 3][j / 3].add(num);
            }
        }

        return true; // If no conflicts, the board is valid
    }
}

package com.leetcode.journey.arrays;

/**
 *
 * https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);

        // Print the updated board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // Directions for the 8 neighbors
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},         {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        // Step 1: Apply rules and use intermediate states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int[] dir : directions) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && Math.abs(board[ni][nj]) == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply rules
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; // Live to dead
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2; // Dead to live
                }
            }
        }

        // Step 2: Finalize the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1; // Dead to live
                } else if (board[i][j] == -1) {
                    board[i][j] = 0; // Live to dead
                }
            }
        }

    }
}

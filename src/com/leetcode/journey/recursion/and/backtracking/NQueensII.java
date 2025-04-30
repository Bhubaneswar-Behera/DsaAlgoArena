package com.leetcode.journey.recursion.and.backtracking;

/**
 *
 * https://leetcode.com/problems/n-queens-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class NQueensII {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));
    }

    public static int totalNQueens(int n) {
        // Arrays to track column, diagonal, and anti-diagonal usage
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] antiDiag = new boolean[2 * n - 1];
        return backtrack(0, n, cols, diag, antiDiag);
    }

    private static int backtrack(int row, int n, boolean[] cols, boolean[] diag, boolean[] antiDiag) {
        // Base case: if all rows are processed, we found a solution
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            int diagIndex = row - col + n - 1;
            int antiDiagIndex = row + col;

            // Check if the current position is safe
            if (cols[col] || diag[diagIndex] || antiDiag[antiDiagIndex]) {
                continue;
            }

            // Place the queen
            cols[col] = true;
            diag[diagIndex] = true;
            antiDiag[antiDiagIndex] = true;

            // Recurse to the next row
            count += backtrack(row + 1, n, cols, diag, antiDiag);

            // Backtrack by removing the queen
            cols[col] = false;
            diag[diagIndex] = false;
            antiDiag[antiDiagIndex] = false;
        }

        return count;
    }
}

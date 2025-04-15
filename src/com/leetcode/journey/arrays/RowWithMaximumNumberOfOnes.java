package com.leetcode.journey.arrays;

/**
 * Given a binary sorted matrix A of size N x N.
 * Find the row with the maximum number of 1.
 *
 * NOTE:
 *
 * If two rows have the maximum number of 1 then return the row which has a lower index.
 * Rows are numbered from top to bottom and columns are numbered from left to right.
 * Assume 0-based indexing.
 * Assume each row to be sorted by values.
 * Expected time complexity is O(rows + columns).
 *
 * Input : A = [[0, 1, 1]         Output : 0
 *              [0, 0, 1]
 *              [0, 1, 1]]
 *
 * Explanation : Row 0 has maximum number of 1s.
 */
public class RowWithMaximumNumberOfOnes {
    public static void main(String[] args) {
        int[][] A = {{0,1,1},
                {0,0,1},
                {0,1,1}};
        System.out.println(solve(A));
    }
    public static int solve(int[][] A) {
        int totalRows = A.length;
        int totalColumns = A[0].length;
        int answer = 0;
        int i = 0;
        int j = totalColumns - 1;

        while (i < totalRows && j >= 0) {
            if (A[i][j] == 0) {
                i++;
            } else {
                answer = i;
                j--;
            }
        }
        return answer;
    }

}

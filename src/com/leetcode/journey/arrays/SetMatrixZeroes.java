package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        setZeroes(matrix);

        System.out.println("\nMatrix After Setting Zeroes:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if the first row needs to be zeroed
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if the first column needs to be zeroed
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Mark rows and columns to be zeroed
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero out cells based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle the first row
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle the first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}

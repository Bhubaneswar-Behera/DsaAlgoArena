package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] result = rotate(A);
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        //Transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        //reverse
        for (int row = 0; row < n; row++) {
            int i = 0;
            int j = n - 1;
            while (i < j) {
                int temp = result[row][i];
                result[row][i] = result[row][j];
                result[row][j] = temp;
                i++;
                j--;
            }
        }
        return result;
    }

    public static void rotateInPlace(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

}

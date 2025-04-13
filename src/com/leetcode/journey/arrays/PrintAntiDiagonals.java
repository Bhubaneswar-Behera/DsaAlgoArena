package com.leetcode.journey.arrays;

/**
 * Given n*n matrix (mat[n][n]) square matrix.
 * Print the anti-diagonal elements.
 * Input :
 *       int[][] matrix = {{1,5,8},
 *                         {4,3,1},
 *                         {6,5,2}};
 *    Output : 8,3,6
 *
 */
public class PrintAntiDiagonals {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,8},
                 {4,3,1},
                 {6,5,2}
                };
        printAntiDiagonal(matrix);
    }
    public static void printAntiDiagonal(int[][] matrix){
        int i = 0;
        int n = matrix.length;
        int j = n - 1;

        while (i < n){
            System.out.print (matrix[i][j]+ " ");
            i++;
            j--;
        }
    }
}

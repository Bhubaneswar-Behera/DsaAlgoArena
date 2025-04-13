package com.leetcode.journey.arrays;

/**
 * Given n*n matrix (mat[n][n]) square matrix.
 * Print the diagonal elements.
 * Input :
 *       int[][] matrix = {{1,5,8},
 *                         {4,3,1},
 *                         {6,5,2}};
 *    Output : 1,3,2
 *
 */
public class PrintDiagonalMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 8},
                {4, 3, 1},
                {6, 5, 2}};
        printDiagonalMatrixBruteForce(matrix);
        System.out.println();
        printDiagonalMatrixOptimized(matrix);
    }

    public static void printDiagonalMatrixBruteForce(int[][] matrix){
        int row = matrix.length;;
        int colum = matrix[0].length;

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < colum ; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
    public static void printDiagonalMatrixOptimized(int[][] matrix){
        int row = matrix.length;


        for (int i = 0; i < row ; i++) {
            System.out.print(matrix[i][i]+" ");
        }
    }
}

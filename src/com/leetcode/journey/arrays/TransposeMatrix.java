package com.leetcode.journey.arrays;

/**
 * Given a 2D integer array A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal,
 * switching the matrix's row and column indices.
 *
 * Input : A = [[1, 2, 3],
 *              [4, 5, 6],
 *              [7, 8, 9]]
 * Output :    [[1, 4, 7],
 *              [2, 5, 8],
 *              [3, 6, 9]]
 *
 * Input : A = [[1, 2],
 *              [1, 2],
 *              [1, 2]]
 * Output :    [[1, 1, 1],
 *              [2, 2, 2]]
 *
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                     {4, 5, 6},
                     {7, 8, 9}};
        int[][] result = printTranspose(matrix);
        for(int[] a : result){
            System.out.println(java.util.Arrays.toString(a));
        }
    }
    public static int[][] printTranspose(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[col][row];

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}

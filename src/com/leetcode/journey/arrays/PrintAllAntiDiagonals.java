package com.leetcode.journey.arrays;

/**
 * Give 2D matrix mat[n][m], print all the anti diagonals.
 * The vacant spaces in the grid should be assigned to 0.
 *
 * Input:
 * m[3][4] =  { {1, 2,  3,  4},
 *              {5, 6,  7,  8},
 *              {9, 10, 11, 12}
 *             }
 * Output:
 *          1 0 0
 *          2 5 0
 *          3 6 9
 *          4 7 10
 *          8 11 0
 *          12 0 0
 *
 *
 */
public class PrintAllAntiDiagonals {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2,  3,  4},
                {5, 6,  7,  8},
                {9, 10, 11, 12}};
        printAllAntiDiagonal(matrix);
    }
    public static void printAllAntiDiagonal(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < cols ; i++) {
            int row = 0;
            int col = i;
            while (i < rows && col >= 0){
                System.out.print(matrix[row][col]+ " ");
                row++;
                col--;
            }
            System.out.println();
        }

        for (int r = 1; r < rows ; r++) {
                int row = r;
                int col = cols - 1;
                while(row < rows && col >= 0){
                    System.out.print(matrix[row][col]+ " ");
                    row++;
                    col--;
                }
            System.out.println();
        }
    }
}

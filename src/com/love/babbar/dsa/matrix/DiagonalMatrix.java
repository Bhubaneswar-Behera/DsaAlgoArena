package com.love.babbar.dsa.matrix;

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
public class DiagonalMatrix {
    public static void printDiagonalBrute(int[][] matrix){
            int n = matrix.length;
            for(int i = 0;i < n;i++){
                for(int j = 0;j < n;j++){
                    if(i == j){
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }
    }
    public static void printDiagonalOptimized(int[][] matrix){
        int n = matrix.length;
        for(int i = 0 ;i < n ;i++){
            System.out.print(matrix[i][i] + " ");
        }
    }

    public static int solve(final int[][] A) {
        int n = A.length;
        int answer = 0;
        for(int i =0;i < n;i++){
            answer = answer + A[i][i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,8},
                          {4,3,1},
                          {6,5,2}};
        printDiagonalBrute(matrix);
        System.out.println();
        printDiagonalOptimized(matrix);
        System.out.println();
        System.out.println(solve(matrix));
    }
}

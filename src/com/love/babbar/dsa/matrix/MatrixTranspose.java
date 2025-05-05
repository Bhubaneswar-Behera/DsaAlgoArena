package com.love.babbar.dsa.matrix;

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
public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] result = solve(A);
        for(int[] a : result){
            //System.out.println(Arrays.toString(a));
        }

        printTranspose(A);

    }
    public static int[][] solve(int[][] A) {
        int n = A.length;
        int c = A[0].length;
        int[][] answer = new int[c][n];
        for(int i = 0 ; i< n ;i++){
            for (int j = 0;j < i ;j++) {
                answer[j][i] = A[i][j];
            }
        }
        return answer;
    }

    public static void printTranspose(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        for(int i = 0 ;i < n ;i++){
            for(int j  = 0 ; j < m ;j++ ){
                System.out.print(A[j][i] + " ");
            }
            System.out.println();
        }
    }
}

package com.neetcode150.binary.search;

/**
 * Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
 * This matrix A has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Return 1 if B is present in A, else return 0.
 *
 * NOTE: Rows are numbered from top to bottom, and columns are from left to right.
 *
 * Input :
 * A = [
 *       [1,   3,  5,  7]
 *       [10, 11, 16, 20]
 *       [23, 30, 34, 50]
 *     ]
 * B = 3
 * Output : 1
 * Explanation :  3 is present in the matrix at A[0][1] position so return 1.
 *
 *Input :
 *A = [
 *       [5, 17, 100, 111]
 *       [119, 120, 127, 131]
 *     ]
 * B = 3
 * Output : 0
 * Explanation : 3 is not present in the matrix so return 0.
 *
 */
public class MatrixSearch {
    public static int searchMatrix(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int i = 0;
        int j = m - 1;

        while(i < n && j >= 0){
            if(A[i][j] == B){
                return 1;
            }
            if ( B > A[i][j]){
                i++;
            } else{
                j--;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][]  A = {  {1,   3,  5,  7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}};

        int B = 3;

        System.out.println(searchMatrix(A,B));
    }
}

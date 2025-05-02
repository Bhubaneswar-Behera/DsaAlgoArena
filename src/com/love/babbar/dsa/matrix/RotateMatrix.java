package com.love.babbar.dsa.matrix;

import java.util.Arrays;

/**
 * You are given a n x n 2D matrix A representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * You need to do this in place.
 *Note: If you end up using an additional array, you will only receive partial score.
 *
 * Example Input:
 *   [
 *     [1, 2],
 *     [3, 4]
 *   ]
 *
 *   Output :
 *   [
 *     [3, 1],
 *     [4, 2]
 *  ]
 * Input :
 *  [
 *     [1, 2, 3],
 *     [4, 5, 6],
 *     [7, 8, 9]
 *  ]
 *  Output :
 *       [
 *       [7, 4, 1],
 *       [8, 5, 2],
 *       [9, 6, 3]
 *    ]
 *
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3},
                     {4, 5, 6},
                     {7, 8, 9}};

        int[][] result = solve(A);
        for(int[] a : result){
            System.out.println(Arrays.toString(a));
        }

    }
    public static int[][] solve(int[][] A) {
        int n = A.length;
        int[][] result = new int[n][n];

       //Transpose
        for(int i = 0;i < n; i++){
            for(int j = 0;j < n; j++){
                result[j][i] = A[i][j];
            }
        }

        //reverse
        for(int row = 0; row < n; row++){
           int i = 0;
           int j  = n - 1;
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

}

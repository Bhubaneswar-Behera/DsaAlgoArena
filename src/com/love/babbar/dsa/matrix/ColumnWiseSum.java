package com.love.babbar.dsa.matrix;


import java.util.Arrays;

/**
 * Given an 2D matrix mat[n][m], print the column-wise sum.
 *
 * m[3][4] = {{1, 2,  3,  4},
 *            {5, 6,  7,  8},
 *            {9, 10, 11, 12}}
 *  Output: 15 18 21 24
 * Explanation :
 *      1+5+9 = 15, 2+6+10=28, 3+7+11= 21, 4+8+12 =24
 *
 */
public class ColumnWiseSum {

    public static int[] solve(int[][] A) {
        int rowLength = A.length;
        int columnLength = A[0].length;
        int[] answer = new int[columnLength];

        for(int i = 0; i < columnLength;i++){
            int sum = 0;
            for(int j = 0 ;j < rowLength;j++){
                sum = sum + A[j][i];
            }
            answer[i] = sum;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] A = {{1, 2,  3,  4},
                     {5, 6,  7,  8},
                     {9, 10, 11, 12}};
        System.out.println(Arrays.toString(solve(A)));
    }
}

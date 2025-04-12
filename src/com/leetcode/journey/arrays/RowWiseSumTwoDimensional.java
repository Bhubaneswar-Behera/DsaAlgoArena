package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 * Given an 2D matrix mat[n][m], print the row-wise sum.
 *
 * m[3][4] = {{1,2,3,4},
 *            {5,6,7,8},
 *            {9,10,11,12}}
 *  Output: 10 26 42
 * Explanation :
 *      1+2+3+4 = 10, 5+6+7+8=26,9+10+11+12 = 42
 *
 */
public class RowWiseSumTwoDimensional {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(Arrays.toString(sumRowWise(arr)));
    }

    public static int[] sumRowWise(int[][] arr){
        int row = arr.length;;
        int column = arr[0].length;
        int[] result = new int[row];

        for (int i = 0; i < row ; i++) {
            int sum = 0;
            for (int j = 0; j < column ; j++) {
                sum = sum + arr[i][j];
            }
            result[i] = sum;
        }
        return result;
    }
}

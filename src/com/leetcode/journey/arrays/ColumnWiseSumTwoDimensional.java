package com.leetcode.journey.arrays;

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
public class ColumnWiseSumTwoDimensional {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(Arrays.toString(columnRowWise(arr)));
    }

    public static int[] columnRowWise(int[][] arr){
        int row = arr.length;
        int column = arr[0].length;
        int[] result = new int[column];

        for (int i = 0; i < column ; i++) {
            int sum = 0;
            for (int j = 0; j < row ; j++) {
                sum = sum + arr[j][i];
            }
            result[i] = sum;
        }

        return result;
    }
}

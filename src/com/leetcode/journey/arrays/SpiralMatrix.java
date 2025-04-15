package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 * Given an integer A, generate a square matrix filled with elements
 * from 1 to A2 in spiral order and return the generated square matrix.
 * Input : n = 5
 * Output 2:
 *  {{ 1,   2,  3,  4, 5},
 *   {16, 17, 18, 19, 6},
 *   {15, 24, 25, 20, 7},
 *   {14, 23, 22, 21, 8},
 *   { 13, 12, 11, 10, 9] ]
 *
 *
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int A = 5;

        int result[][] = generateMatrix(A);
        for(int[] a : result){
            System.out.println(Arrays.toString(a) + " " );
        }
    }
    public static int[][] generateMatrix(int A) {
        int[][] answer = new int[A][A];
        int value = 1;
        int row = 0;
        int column = 0;
        while (A > 1) {//for even number of rows and columns
            for (int index = 1; index < A ; index++) {
                answer[row][column] = value;
                column++;
                value++;
            }
            for (int index = 1; index < A ; index++) {
                answer[row][column] = value;
                row++;
                value++;
            }
            for (int index = 1; index < A ; index++) {
                answer[row][column] = value;
                column--;
                value++;
            }
            for (int index = 1; index < A ; index++) {
                answer[row][column] = value;
                row--;
                value++;
            }
            row++;
            column++;
            A = A - 2;//for each run row and column reduced by 2

        }
        if(A == 1){ //for odd number of rows and columns
            answer[row][column] = value;
        }
        return  answer;
    }
}

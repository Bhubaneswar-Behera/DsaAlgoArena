package com.leetcode.journey.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * https://leetcode.com/problems/spiral-matrix/?envType=study-plan-v2&envId=top-interview-150
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
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return answer;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                answer.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // Traverse from right to left along the bottom boundary (if still within bounds)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    answer.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Traverse from bottom to top along the left boundary (if still within bounds)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }

        return answer;
    }
}

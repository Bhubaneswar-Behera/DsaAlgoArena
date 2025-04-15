package com.leetcode.journey.arrays;

/**
 * Given a matrix of integers A of size N x M and an integer B.
 * In the given matrix every row and column is sorted in non-decreasing order. Find and return the position of B in the matrix in the given form:
 * If A[i][j] = B then return true
 * If B is not present return false.
 *
 * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
 * Note 3: Expected time complexity is linear
 * Note 4: Use 1-based indexing
 *
 *Input
 * A = [[1, 2, 3]           B = 2
 *      [4, 5, 6]
 *      [7, 8, 9]]
 *
 */
public class SearchInARowWiseAnsColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{2,3,6,7},
                {2,3,4,5}};

        int target = 2;

        System.out.println(solve(matrix,target));
    }

    public static boolean solve(int[][] matrix, int target) {
        int totalRows = matrix.length; //total number of rows
        int totalColumns = matrix[0].length; //total number of columns
        int i = 0;
        int j = totalColumns - 1;

        while (i< totalRows && j >= 0){
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}

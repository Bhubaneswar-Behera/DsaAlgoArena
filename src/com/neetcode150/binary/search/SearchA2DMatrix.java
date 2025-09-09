package com.neetcode150.binary.search;

/**
 *
 * https://leetcode.com/problems/search-a-2d-matrix/submissions/1644073156/
 *
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target)); // Output: true
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;

        while(i < n && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            if ( target > matrix[i][j]){
                i++;
            } else{
                j--;
            }
        }
        return false;
    }


}

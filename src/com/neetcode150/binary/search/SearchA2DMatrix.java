package com.neetcode150.binary.search;

/**
 *
 * https://leetcode.com/problems/search-a-2d-matrix/submissions/1644073156/
 * Reference : https://www.youtube.com/watch?v=RhPqIIOUiS8&t=637s
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
        int rowIdx = searchPotentialRow(matrix, target);
        if (rowIdx != -1) {
            return binarySearchOverRow(rowIdx, matrix, target);
        }
        return false;
    }

    private static int searchPotentialRow(int[][] matrix, int target) {
        int firstRowIndex = 0;
        int lastRowIndex = matrix.length - 1;
        int lastColIndex = matrix[0].length - 1;
        while (firstRowIndex <= lastRowIndex) {
            int mid = firstRowIndex + (lastRowIndex - firstRowIndex)/2;

            if (matrix[mid][0] <= target && target <= matrix[mid][lastColIndex]) {
                return mid;
            } else if (target > matrix[mid][0]) {
                firstRowIndex = mid + 1;
            } else if (target < matrix[mid][0]) {
                lastRowIndex = mid - 1;
            }
        }
        return -1;
    }

    private static boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {
        int left = 0;
        int right = matrix[rowIdx].length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;

            if (matrix[rowIdx][mid] == target) {
                return true;
            } else if (target > matrix[rowIdx][mid] ) {
                left = mid + 1;
            } else if(target < matrix[rowIdx][mid]){
                right = mid - 1;
            }
        }
        return false;
    }
}

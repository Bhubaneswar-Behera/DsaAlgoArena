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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        int currentRow = 0;
        int currentColumn = totalColumns - 1;

        // Start from top-right corner
        while (currentRow < totalRows && currentColumn >= 0) {

            int currentValue = matrix[currentRow][currentColumn];

            if (currentValue == target) {
                return true;
            }

            // Move downward if target is greater
            if (target > currentValue) {
                currentRow++;
            } else {
                // Move left if target is smaller
                currentColumn--;
            }
        }

        return false;
    }


}

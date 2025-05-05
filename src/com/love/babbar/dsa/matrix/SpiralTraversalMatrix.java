package com.love.babbar.dsa.matrix;

import java.util.ArrayList;

/**
 *
 *https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 */
public class SpiralTraversalMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                          {1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12},
                            {13, 14, 15, 16}
                        };
        //Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]

        System.out.println(spirallyTraverse(mat));
    }

    // Function to return a list of integers denoting spiral traversal of matrix.
    public static ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (n > 1) {
            for (int index = 1; index < n ; index++) {
                result.add(mat[i][j]);
                j++;
            }
            for (int index = 1; index < n ; index++) {
                result.add(mat[i][j]);
                i++;
            }
            for (int index = 1; index < n ; index++) {
                result.add(mat[i][j]);
                j--;
            }
            for (int index = 1; index < n ; index++) {
                result.add(mat[i][j]);
                i--;
            }
            i++;
            j++;
            n = n - 2;
        }
        if(n == 1){
            result.add(mat[i][j]);
        }
        return  result;
    }
}

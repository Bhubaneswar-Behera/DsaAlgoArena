package com.leetcode.journey.arrays;

public class BoundaryElementsOfAMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4},
                {5, 6, 7,  8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        solve(A);
    }
    public static void solve(int[][] A) {
        int numberOfRows = A.length;
        int rowIndex = 0;
        int columnIndex = 0;
        //Print (n-1) element of Top Row  --> Left To Right
        for (int i = 0;i < numberOfRows - 1;i++) {
            System.out.print(A[rowIndex][columnIndex]+" ");
            columnIndex++;
        }
        //Print (n-1) element of Last Column --> Top To Bottom
        for (int i = 0;i < numberOfRows - 1;i++) {
            System.out.print(A[rowIndex][columnIndex]+" ");
            rowIndex++;
        }
        //Print (n-1) element of Last Row --> Right To Left
        for (int i = 0;i < numberOfRows - 1;i++) {
            System.out.print(A[rowIndex][columnIndex]+" ");
            columnIndex--;
        }

        //Print (n-1) element of 1st Column --> Bottom To Top
        for (int index = 0;index < numberOfRows - 1;index++) {
            System.out.print(A[rowIndex][columnIndex]+" ");
            rowIndex--;
        }
    }
}

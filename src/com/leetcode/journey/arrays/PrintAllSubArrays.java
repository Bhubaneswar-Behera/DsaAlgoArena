package com.leetcode.journey.arrays;

public class PrintAllSubArrays {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, -1, 6, 9, 8, 12};
        printAllSubArray(arr);
    }
    public static void printAllSubArray(int[] arr){
        int n = arr.length;;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n ; j++) {
                for (int k = i; k < j ; k++) {
                    System.out.println(arr[k] + " ");
                }
                System.out.println("\n");
            }
        }
    }
}

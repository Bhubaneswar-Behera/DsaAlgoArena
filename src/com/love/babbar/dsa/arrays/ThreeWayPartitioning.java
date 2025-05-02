package com.love.babbar.dsa.arrays;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/three-way-partitioning/1
 */
public class ThreeWayPartitioning {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4};
        int  a = 1;
        int b = 2;
        threeWayPartition(arr, a, b);
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 3, 4] (partitioned array)
    }
    // Function to partition the array around the range such
    // that array is divided into three parts.
    public static void threeWayPartition(int arr[], int a, int b) {
        // code here
        int low = 0; //pointer to the position where elements smaller than a should go.
        int mid = 0;//pointer to traverses the array and processes each element.
        int high = arr.length - 1; //pointer to the position where elements greater than b should go.

        while (mid <= high) {
            if (arr[mid] < a) {
                // Swap arr[mid] with arr[low] and increment both pointers
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] > b) {
                // Swap arr[mid] with arr[high] and decrement high pointer
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            } else {
                // Element is in the range [a, b], just move mid pointer
                mid++;
            }
        }
    }
}

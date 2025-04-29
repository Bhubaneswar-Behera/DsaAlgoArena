package com.love.babbar.dsa.arrays;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
 */
public class RotateArrayByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotate(arr);
        System.out.println("Rotated Array: "+ Arrays.toString(arr));
    }
    public static void rotate(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < 1 ; i++) {
            int temp = arr[n - 1];

            for (int j = n - 2; j >= 0  ; j--) {
                arr[j+1] = arr[j];
            }
            arr[0] = temp;
        }

    }
}

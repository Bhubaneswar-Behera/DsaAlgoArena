package com.love.babbar.dsa.arrays;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
 */
public class MoveAllNegativeNumbers {
    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, -5, 6, -7, 8 };
        int[] result = moveNegativeNumbers(arr);
        System.out.println(Arrays.toString(result));
        System.out.println("------------------");
        int[] arr1 = { 0, 1, 0, 1,1,0,0,1,0,1 };
        int[] result1 = moveZeros(arr1);
        System.out.println(Arrays.toString(result1));
    }
    public static int[] moveNegativeNumbers(int[] arr){
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n ; i++) {
            if(arr[i] < 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
    public static int[] moveZeros(int[] arr) {
        int n = arr.length;;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
}

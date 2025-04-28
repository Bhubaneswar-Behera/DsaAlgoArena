package com.love.babbar.dsa.arrays;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 */
public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    //without using sorting function
    public static void sort012(int[] arr){
        int n = arr.length;
        int l = 0;
        int m = 0;
        int h = n - 1;

        while (m <= h) {
            if (arr[m] == 0){
                int temp = arr[l];
                arr[l] = arr[m];
                arr[m] = temp;
                l++;
                m++;
            } else if (arr[m] == 1) {
                m++;
            } else {
                int temp = arr[m];
                arr[m] = arr[h];
                arr[h] = temp;
                h--;
            }
        }
    }
}

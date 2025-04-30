package com.love.babbar.dsa.arrays;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 * Merge Two Sorted Arrays Without Extra Space
 */
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {2, 4, 7, 10};
        int[] b = {2, 3};
        mergeArrays(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
    public static void mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int i = 0;
        int j = 0;
        while(i < n){
            // Swap arr1[i] and arr2[0]
            if(arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                //Now re-order arr as it will be not sorted
                sortArray2(arr2);
            }
            i++;
        }
    }

    public static void sortArray2(int[] arr2){
        for (int i = 1; i < arr2.length ; i++) {

            if(arr2[i] < arr2[i-1]){
                int temp = arr2[i];
                arr2[i] = arr2[i-1];
                arr2[i-1] = temp;
            }

        }
    }
}

package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 * Given an array of integers, reverse the array in place
 * from index l to index r.
 *
 * Example:
 * Input: arr = [1, 2, 3, 4, 5], l = 1, r = 3
 * Output: arr = [1, 4, 3, 2, 5]
 * Explanation: The elements from index 1 to index 3 are reversed.
 *
 *
 *
 */
public class ReverseTheArrayInIndex {
    public static void reverseArray(int[] arr, int l,int r){
        int i = l;
        int j = r;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int l = 1;
        int r = 3;
        System.out.println("Before reverse : " + Arrays.toString(arr));
        reverseArray(arr,l,r);
        System.out.println("After reverse  : " + Arrays.toString(arr));
    }
}

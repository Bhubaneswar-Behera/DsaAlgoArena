package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 * Given an array of integers, rotate the array to the right by k steps,
 * where k is non-negative.
 * Example:
 * Input: arr = [1, 2, 3, 4, 5], k = 2
 * Output: arr = [4, 5, 1, 2, 3]
 * Explanation: The elements are rotated to the right by 2 steps.
 *
 * https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class RotateTheArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println("Bruteforce Before rotate : " + Arrays.toString(arr));
        reverseBruteForce(arr,k);
        System.out.println("Bruteforce After rotate  : " + Arrays.toString(arr));
        System.out.println("----------------------------");
        System.out.println("Before rotate : " + Arrays.toString(arr1));
        rotateArray(arr1,k);
        System.out.println("After rotate  : " + Arrays.toString(arr1));

    }

    public static void reverseBruteForce(int[] arr, int k){
        for (int i = 0; i < k ; i++) {
            int n = arr.length;
            int temp = arr[n - 1];
            for (int j = n-1; j > 0 ; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    }

    public static void rotateArray(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        reverseArray(arr, 0, n - 1);
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,n-1);
    }
    public static void reverseArray(int[] arr, int l, int r){
        int i = l;
        int j = r;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}

package com.leetcode.journey.arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void reverseArray(int[] arr){
    int i = 0;
    int j = arr.length - 1;
    while (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("Before reverse : "+Arrays.toString(arr));
        reverseArray(arr);
        System.out.println("After reverse  : "+ Arrays.toString(arr));

    }
}

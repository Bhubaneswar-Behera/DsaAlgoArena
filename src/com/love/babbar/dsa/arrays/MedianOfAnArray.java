package com.love.babbar.dsa.arrays;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/find-the-median0527/1
 */
public class MedianOfAnArray {

    public static void main(String[] args) {
        int[] arr = {90, 100, 78, 89, 67};
        System.out.println(findMedian(arr));
    }
    public static double findMedian(int[] arr) {
        // Code here.
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 0) {
            return (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
        } else {
            return arr[n / 2];
        }
    }
}

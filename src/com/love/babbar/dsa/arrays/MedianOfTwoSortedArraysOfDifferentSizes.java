package com.love.babbar.dsa.arrays;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 */
public class MedianOfTwoSortedArraysOfDifferentSizes {

    public static void main(String[] args) {
        int[] a = { -5, 3, 6, 12, 15 };
        int[] b = { -12, -10, -6, -3, 4, 10 };

        System.out.println(medianOf2(a, b));
    }
    public static double medianOf2(int[] a, int[] b){
        int aLength = a.length;
        int bLength = b.length;

        int[] resultantArray = new int[aLength + bLength];
        int k = 0;

        for (int i = 0; i < aLength ; i++) {
            resultantArray[k] = a[i];
            k++;
        }
        for (int i = 0; i < bLength ; i++) {
            resultantArray[k] = b[i];
            k++;
        }
        // Sort the resultant array
        Arrays.sort(resultantArray);
        int n = resultantArray.length;

        // If the length of the resultant array is even
        if (n % 2 == 0) {
            return (resultantArray[n / 2] + resultantArray[n / 2 - 1]) / 2.0;
        } else {
            // If the length of the resultant array is odd
            return resultantArray[n / 2];
        }

    }
}

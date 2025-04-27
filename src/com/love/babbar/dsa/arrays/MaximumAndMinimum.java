package com.love.babbar.dsa.arrays;

import java.util.Arrays;


public class MaximumAndMinimum {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 9};
        int[] result = findMaxAndMin(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findMaxAndMin(int[] arr) {
        int n = arr.length;
        int[] result = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n ; i++) {
            max = Math.max(max,arr[i]);
        }

        for (int i = 0; i < n ; i++) {
            min = Math.min(min,arr[i]);
        }
        result[0] = max;
        result[1] = min;
        return result;
    }
}

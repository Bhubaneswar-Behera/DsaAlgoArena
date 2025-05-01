package com.love.babbar.dsa.arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 0, 4, 0,2};
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n ; i++) {
            waterTrapped = waterTrapped + Math.min(left[i], right[i]) - arr[i];
        }
        return waterTrapped;
    }
}

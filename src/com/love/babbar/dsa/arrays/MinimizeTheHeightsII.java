package com.love.babbar.dsa.arrays;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1
 */
public class MinimizeTheHeightsII {
    public static void main(String[] args) {
        int[] arr = {3, 9, 12, 16, 20};
        int k = 2;
        System.out.println(getMinDiff(arr, k));
    }
    public static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Initialize the difference between max and min
        int answer = arr[n - 1] - arr[0];

        // Step 3: Adjust the smallest and largest values
        // by minimizing the difference between the max and min value
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        // Step 4: Iterate through the array and calculate the minimized difference
        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(smallest, arr[i + 1] - k);
            int max = Math.max(largest, arr[i] + k);
            if (min < 0) {
                continue;
            }
            answer = Math.min(answer, max - min);
        }

        return answer;
    }
}


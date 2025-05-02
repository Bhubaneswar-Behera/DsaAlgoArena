package com.love.babbar.dsa.arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1
 */
public class MinimumSwapsAndKTogether {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 3};
        int k = 3;
        System.out.println(minSwap(arr, k));
    }

    // Function for finding maximum and value pair
    public static int minSwap(int[] arr, int k) {
        // Complete the function
        int n = arr.length;
        int answer = 0;
        int goodNumbers = 0; // less than k numbers

        for (int i :arr) {
            if(i<= k){
                goodNumbers++;
            }
        }
        if (goodNumbers <=1 ) {
            return 0;
        }

        int left = 0;
        int right  = 0;
        int badNumbersInCurrentWindow = 0;

        while (right < goodNumbers){
            if (arr[right] > k) {
                badNumbersInCurrentWindow++;
            }
            right++;
        }
        answer = badNumbersInCurrentWindow;

        while (right < n){
            if (arr[left] >k) {
                badNumbersInCurrentWindow--;
            }
            if (arr[right] > k) {
                badNumbersInCurrentWindow++;
            }
        answer = Math.min(answer, badNumbersInCurrentWindow);
            left++;
            right++;
        }

        return answer;
    }
}

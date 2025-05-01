package com.love.babbar.dsa.arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
 */
public class SmallestSubArrayWithSumGreaterThanX {

    public static void main(String[] args) {
        int x = 51;
        int[] arr = {1, 4, 45, 6, 0, 19};
        System.out.println(smallestSubWithSum(x, arr));
    }

    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            currentSum = currentSum + arr[end];

            while (currentSum > x) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum = currentSum - arr[start];
                start++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}

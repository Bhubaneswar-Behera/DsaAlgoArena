package com.neetcode150.sliding.window;

import java.util.Arrays;

/**
 *
 * https://neetcode.io/problems/sliding-window-maximum
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,2,1,0,4,2,6};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k))); // Output: [2, 4, 6]
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];

        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }

        return result;
    }
}

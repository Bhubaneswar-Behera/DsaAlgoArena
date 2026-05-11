package com.neetcode150.sliding.window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * https://neetcode.io/problems/sliding-window-maximum
 * Reference : https://www.youtube.com/watch?v=XwG5cozqfaM&t=1678s
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,2,1,0,4,2,6};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindowBruteForce(nums, k))); // Output: [2, 2, 4, 4, 6]
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k))); // Output: [2, 2, 4, 4, 6]
    }


    public static int[] maxSlidingWindow(int[] nums, int k){
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> maxDeque = new ArrayDeque<>();

        int resultIndex = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {

            // Remove indices outside current window
            while (!maxDeque.isEmpty() &&
                    maxDeque.peekFirst() <= windowEnd - k) {

                maxDeque.pollFirst();
            }

            // Remove smaller elements
            while (!maxDeque.isEmpty() &&
                    nums[maxDeque.peekLast()] <= nums[windowEnd]) {

                maxDeque.pollLast();
            }

            // Add current index
            maxDeque.offerLast(windowEnd);

            // Start storing result once first window is formed
            if (windowEnd >= k - 1) {
                result[resultIndex++] = nums[maxDeque.peekFirst()];
            }
        }

        return result;
    }

    /**
     * Time Complexity: O(n * k)
     * Space Complexity: O(1)
     */
    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            result[i] = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                result[i] = Math.max(result[i], nums[j]);
            }
        }

        return result;
    }
}

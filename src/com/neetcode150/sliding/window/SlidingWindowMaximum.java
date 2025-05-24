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
        int[] result = new int[n - k + 1];// result array to store the maximums

        // Deque to store indices
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove the front element if it is out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            // Remove elements from the back of deque if they are smaller than nums[i].
            // as Smaller numbers can’t be the max if there's a bigger number after them.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            // Add the current index
            deque.offer(i);

            // Add the maximum to the result (once the first window is processed)
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }
    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
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

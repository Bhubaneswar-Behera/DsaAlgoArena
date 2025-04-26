package com.leetcode.journey.arrays;

/**
 *
 *
 */
public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps to reach the end: " + jump(nums)); // Output: 2
    }

    public static int jump(int[] nums) {
        int jumps = 0, farthest = 0, currentEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}

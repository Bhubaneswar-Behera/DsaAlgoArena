package com.leetcode.journey.arrays;

/**
 * https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Can reach the last index: " + canJump(nums)); // Output: true
    }

    public static boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false; // If the current index is beyond the farthest reachable index
            }
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest reachable index
        }

        return true; // If we can iterate through the array, we can reach the last index
    }
}

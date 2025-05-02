package com.leetcode.journey.dynamic.programming.one.dimensional;

/**
 *
 * https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums)); // Output: 4
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int prev2 = 0; // Represents dp[i-2]
        int prev1 = 0; // Represents dp[i-1]

        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

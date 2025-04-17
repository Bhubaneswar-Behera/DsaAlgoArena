package com.leetcode.journey.arrays;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("Minimal length: " + minSubArrayLen(target, nums)); // Output: 2
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            currentSum = currentSum + nums[end];

            while (currentSum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum = currentSum - nums[start];
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

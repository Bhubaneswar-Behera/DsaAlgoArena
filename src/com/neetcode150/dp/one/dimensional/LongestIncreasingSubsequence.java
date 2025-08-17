package com.neetcode150.dp.one.dimensional;

/**
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * Reference : https://www.youtube.com/watch?v=Xq3hlMvhrkE
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis.lengthOfLIS(nums)); // Output: 4
        // Explanation: The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
    }

    public int lengthOfLIS(int[] nums) {
        int[] T = new int[nums.length];

        // Start main pointer
        for (int i = 1; i < nums.length; i++) {
            // Start second pointer
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //if (T[j] + 1 > T[i])
                        T[i] = T[j] + 1;
                }
            }
        }

        // find the max value
        int maxIndex = 0;
        for (int i = 0; i < T.length; i++) {
            if (T[i] > T[maxIndex]) {
                maxIndex = i;
            }
        }

        return T[maxIndex] + 1;
    }
}

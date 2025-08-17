package com.neetcode150.dp.one.dimensional;

/**
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * Reference : https://www.youtube.com/watch?v=X50Rknzenus
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(nums)); // Output: true
        // Explanation: The array can be partitioned into two subsets with equal sum: {1, 5} and {5, 11}.
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it's not possible to partition it into two equal sum subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // There's always a way to make up sum 0 with an empty subset

        // Process each number in the array
        for (int num : nums) {
            // Go backwards to prevent using the same element more than once
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}

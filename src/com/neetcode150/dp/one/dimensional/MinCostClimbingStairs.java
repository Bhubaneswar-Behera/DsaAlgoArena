package com.neetcode150.dp.one.dimensional;

/**
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * Reference : https://www.youtube.com/watch?v=WeO_E5Q1kGw
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int[]{10, 15, 20})); // Output: 15
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // Output: 6

    }
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] minCost = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            minCost[i] =
                    Math.min(
                            (cost[i - 1] + minCost[i - 1]),
                            (cost[i - 2] + minCost[i - 2])
                    );
        }

        return minCost[n];
    }

}

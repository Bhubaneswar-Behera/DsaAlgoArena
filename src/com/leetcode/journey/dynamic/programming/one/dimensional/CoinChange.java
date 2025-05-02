package com.leetcode.journey.dynamic.programming.one.dimensional;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/coin-change/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount)); // Output: 3
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize with a large value
        dp[0] = 0; // Base case: 0 coins needed for amount 0

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

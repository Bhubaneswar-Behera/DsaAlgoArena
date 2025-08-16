package com.neetcode150.dp.one.dimensional;

/**
 *
 * https://leetcode.com/problems/coin-change/description/
 * Reference : https://www.youtube.com/watch?v=NNcN5X1wsaw
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        // Output: 3
        // Explanation: 11 = 5 + 5 + 1
    }
    public static int coinChange(int[] coins, int amount) {
        // Check edge case
        if (amount < 1) {
            return 0;
        }

        // Create DP array
        int[] minCoinsDP = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {

            minCoinsDP[i] = Integer.MAX_VALUE;

            // Try each coin
            for (int coin : coins) {
                if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE) {
                    minCoinsDP[i] = Math.min(minCoinsDP[i], 1 + minCoinsDP[i - coin]);
                }
            }
        }

        return minCoinsDP[amount] == Integer.MAX_VALUE ? -1 : minCoinsDP[amount];
    }
}

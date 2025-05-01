package com.love.babbar.dsa.arrays;

public class StockBuyAndSellMax2TransactionsAllowed {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices)); // Output: 7
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0; // Not enough days to make a profit
        }

        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        // Calculate maximum profit from left to right
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        // Calculate maximum profit from right to left
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        // Calculate the maximum profit with two transactions
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxProfit;

    }
}

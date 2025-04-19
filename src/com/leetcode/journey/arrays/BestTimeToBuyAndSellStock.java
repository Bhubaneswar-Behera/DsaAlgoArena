package com.leetcode.journey.arrays;

/**
 * Level : Easy
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices)); // Output: 5
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // No profit can be made
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the minimum price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Calculate and update max profit
            }
        }

        return maxProfit;
    }
    }


package com.leetcode.journey.dynamic.programming.two.dimensional;

/**
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price); // Max profit after first buy
            firstSell = Math.max(firstSell, firstBuy + price); // Max profit after first sell
            secondBuy = Math.max(secondBuy, firstSell - price); // Max profit after second buy
            secondSell = Math.max(secondSell, secondBuy + price); // Max profit after second sell
        }

        return secondSell; // Maximum profit after at most two transactions
    }
}

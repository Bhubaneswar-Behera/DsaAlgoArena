package com.neetcode150.sliding.window;


/**
 *
 * https://neetcode.io/problems/buy-and-sell-crypto
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {10,1,5,6,7,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int currentMin = Integer.MAX_VALUE;

        for (int i = 0; i < n ; i++) {
            currentMin = Math.min(currentMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - currentMin);
        }
        return maxProfit;
    }

}

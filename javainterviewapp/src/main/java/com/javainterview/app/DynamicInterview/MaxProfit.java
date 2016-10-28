package com.javainterview.app.DynamicInterview;


/**
 * LeetCode 121
 * 
 * Company: Amazon, Microsoft, Bloomberg, Uber, Facebook
 * Tags: Array, Dynamic Programming
 * 
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * 
 * 
 * Example 1:
 *   Input: [7, 1, 5, 3, 6, 4]
 *   Output: 5
 * 
 * max. difference = 6-1 = 5 
 * (not 7-1 = 6, as selling price needs to be larger than buying price
 * 
 * Example 2:
 *   Input: [7, 6, 4, 3, 1]
 *   Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        // base cases
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // start with profit of 0
        int maxProfit = 0;

        // minimum price is first indes
        int minPrice = prices[0];

        // loop through all prices starting at 1
        for (int i=1; i < prices.length; i++) {
            // if current price is greater, then we want to sell
            // calculate the max profit which is current profit or selling from minPrice
            if (prices[i] > prices[i-1]) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            } else {
                // if the current price is equal or less than our previous price
                // we want to keep this price as the minimum
                // compare current price with minimum
                minPrice = Math.min(minPrice, prices[i]);
            }
        }

        return maxProfit;
    }

}


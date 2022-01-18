package com.learn.ds.dp;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int[] max = new int[prices.length];
        max[prices.length -1] = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            max[i] = Math.max(prices[i+1], max[i+1]);
        }

        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, max[i] - prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}

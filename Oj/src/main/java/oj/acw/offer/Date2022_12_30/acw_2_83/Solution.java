package oj.acw.offer.Date2022_12_30.acw_2_83;

public class Solution {
    //买卖股票的最佳时机 I
    public int maxProfit(int[] prices) {
        int [][] dp = new int[2][prices.length];
        if(prices.length < 1) return 0;
        int sum = 0,start=prices[0];
        for(int i = 1;i<prices.length;i++){
            if(prices[i]-start > sum){
                sum = prices[i] - start;
            }
            else if(prices[i] < start) start = prices[i];
        }
        return sum;
    }
    //买卖股票的最佳时机 II
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];


    }
    public int maxProfit2_2(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
    // 3
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        for (int k = 0; k <= 2; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            for (int k = 1; k <= 2; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
            }
        }
        return dp[n - 1][2][0];
    }
    public int maxProfit3_2(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }




}

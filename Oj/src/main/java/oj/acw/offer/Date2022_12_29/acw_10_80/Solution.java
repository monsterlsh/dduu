package oj.acw.offer.Date2022_12_29.acw_10_80;

import java.util.Arrays;

public class Solution {

    public double[] dicesProbability(int n) {
        int dp[] = new int[70];

        for (int i = 1; i <= 6; i ++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i ++) {
            for (int j = 6*i; j >= i; j --) {
                dp[j] = 0;
                for (int cur = 1; cur <= 6; cur ++) {
                    if (j - cur < i-1) {
                        break;
                    }
                    dp[j] += dp[j-cur];
                }
            }
        }
        double all = Math.pow(6, n);
       double [] ret = new double[5*n+1];
        for (int i = n,j=0; i <= 6 * n; i ++,j++) {
            ret[j]=(dp[i] * 1.0 / all);
        }
        return ret;
    }

    public double[] dicesProbability2(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }


}

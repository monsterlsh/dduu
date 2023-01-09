package oj.acw.offer.Date2022_12_18.acw_7_60;

public class Solution {

    public int getMaxValue(int[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length == 0)return 0;
        int n = grid.length , m=grid[0].length;
        int [] dp = new int[m];
        dp[0] = grid[0][0];
        for (int j=1;j<m;j++){
            dp[j] = grid[0][j]+dp[j-1];
        }
        for (int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0) dp[j] += grid[i][j];
                else
                dp[j] = Math.max(dp[j]+grid[i][j],grid[i][j]+dp[j-1]);
            }
        }
        return dp[m-1];
    }
    public static void main(String[] args) {
        //[[4, 7, 4],
        // [9, 7, 7]]
    }
}

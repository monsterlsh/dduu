package oj.luogu.basically.P1049;

import java.util.Scanner;

public class Main {
    int v,n;
    int [] arr;
    Scanner scanner;
    public Main(){
        scanner = new Scanner(System.in);
        v= scanner.nextInt();
        n = scanner.nextInt();
        arr = new int[n+1];
        for (int i = 1;i<arr.length;i++) arr [i] = scanner.nextInt();
    }
    public void result(){
        int [][] dp = new int[arr.length][v+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=v;j++){
                if(j >= arr[i])
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i]]+arr[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(v - dp[n][v]);
    }
    public void result2(){
        int [] dp = new int[v+1];
        for(int i=1;i<=n;i++){
            for(int j=v;j>=arr[i];j--){
                dp[v] = Math.max(dp[v],dp[v-arr[i]]+arr[i]);
            }
        }
        System.out.println(v - dp[v]);
    }
    public static void main(String[] args) {
        new Main().result();
    }
}

package oj.luogu.basically.P1060;


import java.util.Scanner;

public class Main {
    int v,n;
    int [][] arr;
    Scanner scanner;
    public Main(){
        scanner = new Scanner(System.in);
        v= scanner.nextInt();
        n = scanner.nextInt();
        arr = new int[n+1][3];
        for (int i = 1;i<arr.length;i++) {
            arr [i][0] = scanner.nextInt();
            arr [i][1] = arr [i][0] *scanner.nextInt();

        }
    }
    public void result(){
        int [][] dp = new int[arr.length][v+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=v;j++){
                if(j >= arr[i][0])
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i][0]]+arr[i][1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[n][v]);
    }
    public void result2(){
        int [] dp = new int[v+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=v;j++){

                if(j >= arr[i][0])
                    dp[j] = Math.max(dp[j],dp[j-arr[i][0]]+arr[i][1]);

            }
        }
        System.out.println(dp[v]);
    }
    public static void main(String[] args) {
        new Main().result2();
    }
}

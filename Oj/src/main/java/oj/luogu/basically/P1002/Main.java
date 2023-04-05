package oj.luogu.basically.P1002;

import java.util.Scanner;

public class Main {
    int n,m,a,b;
    Scanner scanner;
    int [][] graph;
    long count;
    public Main(){
        scanner = new Scanner(System.in);
        n = scanner.nextInt()+1;
        m = scanner.nextInt()+1;
        a = scanner.nextInt()+1;
        b = scanner.nextInt()+1;
        graph = new int[n+1][m+1];
        count = 0;
        int[][] step = {{0,0},{1,2},{-1,2},{-1,-2},{1,-2},
                        {2,1},{-2,1},{2,-1},{-2,-1}};
        for (int[] ints : step)
            if (check(a + ints[0], b + ints[1]))
                graph[a + ints[0]][b + ints[1]] = 1;
    }
    private boolean check(int x,int y){
        return x>=1 && x<=n && y>=1 && y<=m;
    }
    public void dps(){
        long dp [] = new long[m+1];
//        for(int i=0;i<=n && graph[i][0]!=1;i++) dp[i][0]=1;
//        for(int i=0;i<=m && graph[0][i]!=1;i++) dp[0][i]=1;
        if(graph[1][1] ==1) {
            System.out.println(0);
            return;
        }
        dp[1]=1;
        for(int i=1; i<=n;i++){
            for(int j=1;j<=m;j++){
                if(graph[i][j] == 1) dp[j] =0;
                else dp[j] +=  dp[j-1];
            }
        }
        count = dp[m];
        System.out.println(count);
    }

    public static void main(String[] args) {
        new Main().dps();
    }
}

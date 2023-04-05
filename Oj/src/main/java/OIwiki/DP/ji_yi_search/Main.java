package OIwiki.DP.ji_yi_search;

import java.util.Arrays;

/*
山洞里有 M 株不同的草药，采每一株都需要一些时间 t_i，每一株也有它自身的价值 v_i。
给你一段时间 T，在这段时间里，你可以采到一些草药。让采到的草药的总价值最大。
 */
public class Main {
    int n,t;
    public static int N = 10003;
    int[] tcost = new int[N];
    int[] wcost = new int[N];
    int ans = 0;
    void dfs(int p,int l,int tans){
        if(l < 0) return;
        if(p == n+1) {
            ans = Math.max(ans,tans);
            return;
        }
        dfs(p+1,l,tans);
        dfs(p+1,l-tcost[p],tans+wcost[p]);
    }
    void normal_search(){
        dfs(1,t,0);
    }

    /*
      记忆搜索
     */
    int [][] mem = new int[N][N];
    int dfs2(int p,int l){
        if(mem[p][l] != -1) return mem[p][l];
        if(p == n+1)  return mem[p][l] =0;
        int no_choose  = 0 , chose = Integer.MIN_VALUE;
        no_choose = dfs2(p,l);
        if(l >= tcost[p]) chose = dfs2(p+1,l-tcost[p]) + wcost[p];
        return mem[p][l] = Math.max(no_choose,chose);
    }
    void state_search(){
        for(int i=0;i<=n;i++) Arrays.fill(mem[i],-1);
        dfs2(1,t);
    }
}

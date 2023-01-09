package oj.acw.AlgorithmAdvanceIntroduce.p96;

import java.util.Arrays;

public class Main {
    int m,n;
    int d[];
    int f[];
    public Main(int m,int n){
        this.m = m;
        this.n = n;
        d = new int[n];
        f =  new int[n];
        Arrays.fill(f,0x3f3f3f3f);
    }
    public void print(){
        if(f == null) return;
        for (int i = 0; i < m; i++) {
            System.out.println(f[i]);
        }
    }
    public void solu(){
        for(int i=1; i<=m;i++) d[i] = 2*d[i-1]+1;
        f[1]=1;
        for (int i = 2; i <= m; i++)
            for (int j = 1; j < i; j++)
                f[i] = Math.min(f[i],2*f[j] + d[i-j]);
        print();
    }
    public static void main(String[] args) {
        new Main(12,15).solu();

    }
}

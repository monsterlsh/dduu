package oj.acw.LQB.ch7.acw112;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N = 1010;
    static class Pair implements Comparable<Pair>
    {
        double l,r;
        Pair(double l,double r)
        {
            this.l = l;
            this.r = r;
        }
        @Override
        public int compareTo(Pair o) {
            // TODO 自动生成的方法存根
            return Double.compare(r, o.r);
        }
    }
    static Pair[] pair = new Pair[N];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        boolean flag = true;
        for(int i = 0;i < n;i ++)
        {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(!flag) continue;
            if(d < y) flag = false;
            else
            {
                double len = Math.sqrt(d * d - y * y);
                double l = x - len;
                double r = x + len;
                pair[i] = new Pair(l,r);
            }
        }
        if(!flag) System.out.println("-1");
        else
        {
            Arrays.sort(pair,0,n);
            double end = pair[0].r;
            int res = 1;
            for(int i = 1;i < n;i ++)
            {
                if(pair[i].l <= end) continue;
                end = pair[i].r;
                res ++;
            }
            System.out.println(res);
        }
    }
}


package oj.acw.LQB.ch5;

import java.util.*;
import java.io.*;
import java.math.*;

public class acw1270 {
    public static  int N  = 100010;
    public static  Node tr []  = new Node[4*N];
    public static int [] w = new int[N];
    public static void push_up(int u){
        tr[u].maxv = Math.max(tr[u <<1].maxv,tr[u << 1 | 1].maxv);
    }
    public static void build(int u,int l,int r){
        if(l == r ) {tr[u] = new Node(l,r,w[r]);
            return;
        }
        tr[u] = new Node(l,r,0);
        int mid = l+r >> 1;
        build(u << 1,l,mid);
        build(u<< 1 | 1,mid+1,r);
        push_up(u);

    }
    public static int query (int u,int l,int r){
        if(l<=tr[u].l && tr[u].r <= r) return tr[u].maxv;
        int mid = tr[u].l + tr[u].r >> 1;
        int maxv = Integer.MIN_VALUE;
        if(l <= mid ) maxv = Math.max(maxv,query(u<<1, l,r));
        if(r>=mid+1) maxv = Math.max(maxv,query(u<<1 | 1, l,r));
        return  maxv;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s [] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String str[] = br.readLine().split(" ");
        for(int i = 1; i <= n; i ++ ) w[i] = Integer.parseInt(str[i - 1]);

        //构造线段树
        build(1, 1, n);
        while(m -- > 0)
        {
            String s1[] = br.readLine().split(" ");
            int l = Integer.parseInt(s1[0]);
            int r = Integer.parseInt(s1[1]);
            bw.write(query(1, l, r) + "\n");
        }
        bw.flush();

    }
}
class Node{
    public int l;
    public int r;
    public int maxv;
    public Node(int l,int r,int maxv){
        this.l = l ;
        this.r = r;
        this.maxv = maxv;
    }
}

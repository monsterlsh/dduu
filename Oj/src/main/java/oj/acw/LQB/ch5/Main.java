package oj.acw.LQB.ch5;

import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static final int N = 100010;
    static int[] w = new int[N]; //数列
    static void push_up(int u) //利用当前节点的两个孩子来更新当前节点的最大值maxv
    {
        tr[u].maxv = Math.max(tr[u << 1].maxv, tr[u << 1 | 1].maxv); //两个孩子节点最大值的最大值
    }
    static void build(int u, int l, int r) //第一个参数是当前节点的编号，l是当前区间的左端点，r是右端点
    {
        if(l == r) tr[u] = new Node(l, r, w[r]); //当前是叶子节点，直接赋值
        else
        {
            tr[u] = new Node(l, r, 0);
            int mid = l + r >> 1; //递归找，边界是中点
            build(u << 1, l, mid); //递归左孩子
            build(u << 1 | 1, mid + 1, r); //递归右孩子
            push_up(u); //最后要更新当前节点maxv的信息
        }

    }
    static int query(int u, int l, int r) //查询区间函数，u是当前结点，l，r是要查询区间的左右端点
    {
        if(l <= tr[u].l && tr[u].r <= r) return tr[u].maxv; //如果当前区间被包含再要查询区间里面，返回该最大值
        //否则
        int mid = tr[u].l + tr[u].r >> 1; //当前区间一分为二进行递归
        int maxv = Integer.MIN_VALUE; //先赋值为最小值
        if(l <= mid) maxv = Math.max(maxv, query(u << 1, l, r)); //如果递归左孩子与查询区间有交集，那么继续递归
        if(r >= mid + 1) maxv = Math.max(maxv, query(u << 1 | 1, l, r)); //递归右孩子同理
        return maxv; //最后返回最大值
    }
    static Node tr[] = new Node [4 * N];
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s[] = br.readLine().split(" ");
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
//class Node
//{
//    public int l; //左右端点
//    public int r;
//    public int maxv; //当前区间中的最大值
//    public Node(int l, int r, int maxv)
//    {
//        this.l = l;
//        this.r = r;
//        this.maxv = maxv;
//    }
//}

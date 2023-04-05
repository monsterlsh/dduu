package oj.acw.LQB.ch2.acw1227.ans;

import java.io.*;
public class Main
{
    static int n, k;

    static final int N = 100010;
    static int[] h = new int[N];
    static int[] w = new int[N];

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static boolean check(int mid)
    {
        int res = 0;
        for (int i = 0; i < n; i ++ )
        {
            res += (h[i] / mid) * (w[i] / mid);
            if (res >= k) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException
    {
        String[] init = in.readLine().split(" ");
        n = Integer.parseInt(init[0]);
        k = Integer.parseInt(init[1]);

        for (int i = 0; i < n; i ++ )
        {
            String[] data = in.readLine().split(" ");
            h[i] = Integer.parseInt(data[0]);
            w[i] = Integer.parseInt(data[1]);
        }

        int l = 1, r = 100000;
        while (l < r)
        {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }

        System.out.println(l);
        in.close();
    }
}

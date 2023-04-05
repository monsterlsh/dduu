package main.java.oj.acw.LQB.ch5;

import java.util.*;
import java.io.*;
public class acw797 {
    static final int N = 100010;
    static int n,m,l,r,c;
    static int []arr = new int[N];
    static int []d = new int[N];
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       String[] split = br.readLine().split(" ");
       n = Integer.parseInt(split[0]);
       m = Integer.parseInt(split[1]);
       split = br.readLine().split(" ");
       for(int i=1;i<=n;i++){
          arr[i] = Integer.parseInt(split[i-1]);
          d[i] = arr[i]-arr[i-1];
       }
       while(m-- > 0){
        split = br.readLine().split(" ");
       
        l = Integer.parseInt(split[0]);
        r = Integer.parseInt(split[1]);
        c = Integer.parseInt(split[2]);
        d[l] += c;
        d[r+1]-=c; 
       }
       for(int i=1;i<=n;i++){
        d[i] += d[i-1];
        //System.out.print(arr[i]+(i==n?"\n":" "));
        bw.write(d[i]+(i==n?"\n":" "));
     }
     bw.flush();

    }

}
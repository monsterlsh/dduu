package oj.acw.LQB.ch5;

import java.util.*;
import java.io.*;
public class acw798 {
    static int n,m,q;
    static final int N = 1010;
    static int [] []arr  = new int[N][N];
    static int [] []d  = new int[N][N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void df(boolean print)throws IOException{
        for(int i=1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(print)
                bw.write(d[i][j]+((j==m)?"\n":" "));
                else
                d[i][j]=d[i][j] +d[i-1][j] + d[i][j-1]-d[i-1][j-1];
            }
        }
    }
    public static void main(String [] args)throws IOException{
        
        String [] spilt = br.readLine().split(" ");
        n = Integer.parseInt(spilt[0]);
        m = Integer.parseInt(spilt[1]);
        q = Integer.parseInt(spilt[2]);
        for(int i=1;i<=n;i++){
            spilt = br.readLine().split(" ");
            for(int j=1;j<=m;j++){
                arr[i][j] = Integer.parseInt(spilt[j-1]);
                d[i][j] += arr[i][j] ;
                d[i+1][j]-=arr[i][j]; 
                d[i+1][j+1]+=arr[i][j]; 
                d[i][j+1]-=arr[i][j]; 
                
            }
        }
        int x1,y1,x2,y2,c;
        while(q-- > 0 ){
            spilt = br.readLine().split(" ");
            x1 = Integer.parseInt(spilt[0]);
            y1 = Integer.parseInt(spilt[1]);
            x2 = Integer.parseInt(spilt[2]);
            y2 = Integer.parseInt(spilt[3]);
            c = Integer.parseInt(spilt[4]);
            d[x1][y1] += c;
            d[x2+1][y1]-=c;
            d[x1][y2+1] -=c;
            d[x2+1][y2+1]+=c;
        }
        df(false);
        df(true);
        bw.flush();
    }
}

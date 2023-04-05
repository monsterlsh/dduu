package oj.acw.LQB.ch2.acw1227;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    int n,k;
    ArrayList<int []> ckl = new ArrayList<>();
    public Main(){
        read();
    }
    int check(int x){
        int h,w;
        int sum = 0;
        for(int [] tmp : ckl){
            h = tmp[0];
            w = tmp[1];
            if(x>h || x >w) continue;
            sum+=(h/x)*(w/x);
        }
        return sum;
    }
    void read(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int h,w,l = 1,r=10000,mid,ans=Integer.MIN_VALUE,sum;
        for(int i=0;i<n;i++) {
            h = sc.nextInt();
            w = sc.nextInt();
            ckl.add(new int []{h,w});
        }
        while (l<=r){
            mid = l + ((r-l)>>1);
            sum = check(mid);
            if( sum >= k){
                ans = Math.max(ans,mid);
                l = mid+1;
            }else r = mid-1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        new Main();
    }
}

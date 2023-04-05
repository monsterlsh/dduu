package oj.acw.LQB.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    int n;
    Scanner sc = new Scanner(System.in);
    int arr [] = new int[10010];
    int res [] = new int[4];
    ArrayList<int []> ans = new ArrayList<>();
    public Main(){
        for(int i =0;i<arr.length;i++) arr[i] = i*i;
        //while (sc.hasNext()){
            read();
            for(int [] tmp : ans) System.out.println(Arrays.toString(tmp));
       // }
    }
    void bianry(int l,int r,int target,int dep){
        if(dep >=4 ) {
            if(target==0)
            ans.add(Arrays.copyOf(res,res.length));
            return;
        }
        int mid,tmp;
        while(l<=r){
             mid = l + ((r-l)>>1);
             tmp = arr[mid];
            if(tmp == target) {
                res[dep] = mid;
                for(int i = dep+1;i<4;i++) res[i] = 0;
                ans.add(Arrays.copyOf(res,res.length));
                return;
            }
            else if(tmp < target) {
                res[dep] = arr[mid];
                bianry(l,r,target-arr[mid],dep+1);
                //res[dep] = 0;
                l = mid+1;
                bianry(l,r,target-arr[mid],dep+1);

            }else {
                r = mid-1;
            }
        }
    }
    void read(){
        n = sc.nextInt();
        bianry(0,arr.length,n,0);
    }
    public static void main(String[] args) {
        new Main();
        //System.out.println(2 + (2-2)>>1);
    }
}

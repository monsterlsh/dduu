package oj.luogu.basically.P1014;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    int  n;
    Scanner scanner;
    public Main(){
        scanner = new Scanner(System.in);
        n = scanner.nextInt();
    }
    public void find(){

       int r = (int)Math.sqrt(2*10e8),l=1;
       int [] arr = new int[r];
       int i=1;
       for (;i<arr.length && arr[i-1] <= n;i++){
           arr[i] += arr[i-1]+i;
       }
       int target =n;
        r = i-1;
        r = search(l,r,target,arr,false);
        l = 1;
        target = arr[r]-target+1;
        target = search(l,r,target,arr,true);
        if(r%2 == 1) System.out.println(target+"/"+(r-target+1));
        else System.out.println((r-target+1) + "/" + target);
    }
    public void test(){
        while (true){
            n = scanner.nextInt();
            find();
        }

    }
    private int search(int l,int r,int target,int arr[],boolean second){
        while (l < r){
            int mid = l + (r-l)/2;
            if((arr[mid]>=target && !second) || (second && mid >= target)) r = mid;
            else l = mid+1;
        }
        return r;
    }
    public static void main(String[] args) {
       //new Main().test();
        new Main().find();
    }
}

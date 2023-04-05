package oj.acw.LQB.ch7.acw122;

import java.util.Scanner;

public class Main {
    int n;
    Scanner scanner = new Scanner(System.in);
    void read(){
        n = scanner.nextInt();
        int arr [] = new int[n];
        int max = -1,idx=0,avg=0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if(max < arr[i]){
                max = arr[i];
                idx = i;
            }
            avg += arr[i];
        }
        avg /= n;
        int j=0,res=0,tmp;
        while (j < n){
            if (arr[idx] > avg && arr[idx]>arr[(idx+1)%n]) {
                tmp = arr[idx]-Math.min(avg,arr[(idx+1)%n]);
                res+= tmp;
                arr[(idx+1)%n] +=tmp;
                arr[idx]-=tmp;
            }
            if (arr[idx] > avg && arr[idx]>arr[(idx-1)%n]) {
                tmp = arr[idx]-Math.min(avg,arr[(idx-1)%n]);
                res+= tmp;
                arr[(idx-1)%n] +=tmp;
                arr[idx]-=tmp;
            }

            idx = (idx+1)%n;
            if(arr[idx] == avg)
            j++;
        }
        System.out.println(res);

    }

    public static void main(String[] args) {
        new Main().read();
    }
}

package oj.luogu.basically.P1046;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] arr = new int[10];
        int n = 0,res =0;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i < 10;i++){
            arr[i] = scanner.nextInt();
        }
        n = scanner.nextInt()+30;
        Arrays.sort(arr);
        for(int i = 0;i < 10;i++){
            if(n>=arr[i]) res++;
            else break;
        }
        System.out.println(res);
    }
}

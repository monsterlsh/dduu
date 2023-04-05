package oj.luogu.basically.P1012;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    int n;
    String  [] arr;
    Scanner scanner;

    public Main(){
        scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new String[n];
        for(int i=0; i < n; i++){
            arr[i] = scanner.next();

        }
    }
    public void res(){
        Arrays.sort(arr,(a,b)-> -(a+b).compareTo(b+a));
        for (String s : arr) {
            System.out.print(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Main().res();
    }
}

package oj.luogu.basically.P1035;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt(),n=1;
        double sn = 0;
        while (sn <=  k){
            sn += 1.0/n;
            n++;
        }
        System.out.println(n-1);
    }
}

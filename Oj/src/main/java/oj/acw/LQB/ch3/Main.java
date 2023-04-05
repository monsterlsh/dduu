package oj.acw.LQB.ch3;

import java.util.Scanner;

public class Main {
    int n;
    public Main(){
        read();
    }
    void read(){
        n = new Scanner(System.in).nextInt();
        if(n<3){
            System.out.println(n);
            return;
        }
        int sum =0,q=0;
        while( n>0){
            sum+=n;
            n = (n+q)/3;
            q = (n+q)%3;
        }
        int res = n;
        while (n >= 3)
        {
            res += n / 3; // res += [当前可兑换的瓶数]
            n = n / 3 + n % 3; //n = [当前可兑换的瓶数] + [兑换后剩余的瓶数]
        }
        //if(q>=)
        System.out.println(res);
    }

    public static void main(String[] args) {
            new Main();
    }
}

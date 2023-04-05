package oj.luogu.basically.P1011;

import java.util.Scanner;

public class Main {
    int a,n,m,x;
    Scanner scanner = new Scanner(System.in);
    int [][] arr ;

    int [] upa;
    int [] upy;
    public Main(){
        a = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();
        x = scanner.nextInt();

        upa = new int[n+1];
        upy = new int[n+1];
        upa[3] = 1;
        upy[2] = 1; upy[3] = 1; for (int i = 4; i <=n ; i++) {
        upa[i] = upa[i-1]+upa[i-2];
        upy[i] = upy[i-1]+upy[i-2];
        }
    }
    public void result(){
        if(x==1 || x==2) {
            System.out.println(a);
            return;
        }
        if(x==n) {
            System.out.println(m);
            return;
        }


        int anum = 1,ax=0;
        int ynum = 0,yx=0;
        for (int i = 3; i <=n-1; i++) {
            anum += upa[i]-upa[i-1];
            ynum  +=upy[i] - upy[i-1];
            if(i==x){ax=anum; yx=ynum;}
        }
        int y = (m - (anum*a))/ynum;

        int res = ax*a+yx*y;
        System.out.println(res);

    }

    public static void main(String[] args) {
        new Main().result();
    }
}

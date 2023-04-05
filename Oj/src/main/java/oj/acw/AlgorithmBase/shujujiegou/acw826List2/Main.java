package oj.acw.AlgorithmBase.shujujiegou.acw826List2;

import java.util.Scanner;

public class Main {
    static final int N = 1000010;
    int [] e = new int[N],l= new int[N],r= new int[N];
    int idx = 2;
    public Main(){
        l[0] = 1;
        r[1] = 0;
    }
    public void insertR(int a,int x){
        e[idx] = x;
        l[idx] = a;
        r[idx] = r[a];
        l[r[a]] = idx;
        r[a] = idx ++ ;
    }
    public void solu(){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String op;
        int x;
        while (m-- > 0){
            op = scanner.next();
            x = scanner.nextInt();
            if(op.equals("R")){

            }
            else if (op.equals("L")){

            }
        }
    }
}

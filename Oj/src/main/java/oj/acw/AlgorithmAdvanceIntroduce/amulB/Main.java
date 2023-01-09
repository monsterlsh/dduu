package oj.acw.AlgorithmAdvanceIntroduce.amulB;

import java.util.ArrayList;
import java.util.Scanner;


public class Main{

    public long read2(){
        String a;
        long b,p;
        try (Scanner scanner = new Scanner(System.in)) {
            a = scanner.next();
            b = scanner.nextLong();
            p = scanner.nextLong();
        }
        return multi2(a,b,p);
    }

    public long multi2(String a,long b,long p){
        ArrayList<Long> builder = new ArrayList<>(a.length() + 1);
        long t = 0;
        int n = a.length();
        for(int i=0;i<n || t!=0 ;i++){
            if(i<a.length()){
                t+=(a.charAt(n-i-1)-'0')*b;
            }
            builder.add(t%10);
            t=t/10;
        }
        //System.out.println("test:"+builder);
        while (builder.size() > 1 && builder.get(builder.size()-1)==0) builder.remove(builder.size()-1);
        n = builder.size();
        for(int i=n-1;i>=0;i--)
            t = (t*10 + builder.get(i));

        return t;

    }
    //java 不能过
    public long multi(long a,long b,long c){
        long ans = 1;
        int i = 0;
        while (b!=0){
            if((b&1) == 1){
                ans = ((ans)+(a)) %c;
                System.out.println("i="+(i++) + "; ans = "+ans);
            }
            a=2*a%c;
            System.out.println("i="+(i++)+"; a = "+ a);
            b >>= 1;
        }
        return ans%c;
    }
    public long read(){
        long a,b,p;
        try (Scanner scanner = new Scanner(System.in)) {
            a = scanner.nextLong();
            b = scanner.nextLong();
            p = scanner.nextLong();
        }
        return multi(a,b,p);
    }
    /*
    250182048980811753
    413715569939057660
    133223633696258584
    ans = 19308689043391716

    9223372036854775807
    9223372036854775807
    *
     */
    public static void main(String[] args) {

        long res = new Main().read();
        //long res = Long.MAX_VALUE;
        System.out.println(res);
    }
}
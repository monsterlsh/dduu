package oj.acw.AlgorithmBase.primary.highPercision.add;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int add(StringBuilder list,int i,String a,int ch){
        int tmp;
        while (i>=0) {
            tmp = a.charAt(i--)-'0'+ch;
            list.append(tmp%10);
            ch = tmp/10;
        }
        return ch;
    }
    public String add(String a, String b){
        int na=a.length(),nb=b.length(),i=na-1,j=nb-1,ch=0,tmp;
        StringBuilder list = new StringBuilder(Math.max(nb, na));
        while (i>=0 && j>=0){
            tmp = a.charAt(i--)-'0'+b.charAt(j--)-'0'+ch;
            list.append(tmp%10);
            ch = tmp/10;
        }
        ch = add(list,i,a,ch);
        ch = add(list,j,b,ch);
        if(ch!=0) list.append(ch);
        list.reverse();
        return list.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String  b = reader.readLine();
        String res = new Main().add(a,b);
        System.out.println(res);
    }
}

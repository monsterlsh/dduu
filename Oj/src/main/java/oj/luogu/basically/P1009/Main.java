package oj.luogu.basically.P1009;

import java.util.Scanner;

public class Main {
    int n;

    public Main(){
        n = new Scanner(System.in).nextInt();
    }
    public void result(){
        int tmp = 1;
        String res = Integer.toString(1);
        String sum = "1";
        while (++tmp  <= n){

            res = multi(res,Integer.toString(tmp));
            sum = add(sum,res);
        }
        System.out.println(sum);

    }
    private String add(String a,String b) {
        int len = Math.max(a.length(), b.length());
        StringBuilder stringBuilder = new StringBuilder(len + 2);
        int[] arr = new int[stringBuilder.capacity()];
        int ch = 0,tmp=0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; j--, i--) {
            tmp = (i>=0 ? a.charAt(i)-'0':0)  + ( j>=0 ? b.charAt(j)-'0':0 )+ch ;
            stringBuilder.append(tmp%10);
            ch = tmp/10;
        }
        if(ch!=0) stringBuilder.append(ch);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
    private String multi(String a,String b){
        int len = a.length()+b.length();
        StringBuilder stringBuilder = new StringBuilder(len + 10);

        int [] arr = new int[stringBuilder.capacity()];
        for(int i = a.length()-1,ii=0;i>=0;i--,ii++){
            for(int j=b.length()-1,jj=0;j>=0;j--,jj++){
                arr[ii+jj] +=  (a.charAt(i)-'0')*(b.charAt(j)-'0');
            }
        }
        int i=0;
        for(;i<arr.length-1;i++){
            arr[i+1] +=arr[i]/10;
            arr[i] %=10;
        }
        i--;
        while (i>=0 && arr[i]==0) i--;
        while (i>=0)
            stringBuilder.append(arr[i--]);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new Main().result();
    }
}

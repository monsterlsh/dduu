package oj.luogu.basically.P1030;

import java.util.Scanner;

public class Main {
    String mid,rear;
    Scanner scanner;
    StringBuilder builder;
    public Main(){
        scanner = new Scanner(System.in);
        mid = scanner.next();
        rear = scanner.next();
        builder = new StringBuilder(mid.length());
    }
    public void solution(){
        dfs(0,mid.length()-1,0,rear.length()-1);
        System.out.println(builder);
    }
    private void dfs(int midl,int midr,int rearl,int rearr){
        if(midl>midr || rearl > rearr) return;
        char first = rear.charAt(rearr);
        builder.append(first);
        if(midl==midr || rearl==rearr) return;
        int midFirst = mid.indexOf(first,midl);
        //for(;midFirst<=midr && mid.charAt(midFirst)!=first;midFirst++);
        dfs(midl,midFirst-1,rearl,rearl+midFirst-1-midl);
        dfs(midFirst+1,midr,rearl+midFirst-midl,rearr-1);

    }

    public static void main(String[] args) {
        new Main().solution();
    }
}

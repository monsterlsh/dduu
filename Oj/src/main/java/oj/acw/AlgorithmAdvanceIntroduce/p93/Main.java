package oj.acw.AlgorithmAdvanceIntroduce.p93;

import java.util.*;


public class Main {
    List<Integer> tmp;
    int n,m ;
    public Main(){
        tmp =new ArrayList<>();;
        n =0;
        m=0;
    }
    private void print(){
        if(tmp.size()!=m)return;
        for(int i = 0;i<tmp.size();i++){
            System.out.print(tmp.get(i)+(i==m-1?"\n":" "));
        }

    }
    public void read(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.close();
        System.out.println();
        if(n==1){
            System.out.println(n);
            return;
        }
        dfs(1);


    }
    private void dfs(int i ){
        for(int j=i;j<=n;j++){
            tmp.add(j);
            print();
            dfs(j+1);
            if(!tmp.isEmpty())
                tmp.remove(tmp.size()-1);
        }

    }
    public static void main(String[] args) {
        new Main().read();

    }
}

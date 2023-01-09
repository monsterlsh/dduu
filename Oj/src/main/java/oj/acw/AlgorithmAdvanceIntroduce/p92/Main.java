package oj.acw.AlgorithmAdvanceIntroduce.p92;

import java.util.*;


public class Main {
    List<Integer> tmp;
    int n ;
    public Main(){
        tmp =new ArrayList<>();;
        n = 0;
    }
    private void print(){
        for(int i = 0;i<tmp.size();i++){
            System.out.print(tmp.get(i)+(i==tmp.size()-1?"\n":" "));
        }
    }
    public void read(){
        n = new Scanner(System.in).nextInt();
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

            dfs(j+1);
            print();
            if(!tmp.isEmpty())
                tmp.remove(tmp.size()-1);
        }

    }
    public static void main(String[] args) {
        new Main().read();

    }
}

package oj.luogu.basically.P1010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    int n;
    HashMap<Integer,String> table = new HashMap<>();
    public Main(){
        n = new Scanner(System.in).nextInt();
        init();
    }

    public void solu(){
        StringBuilder builder = new StringBuilder();
        boolean flag;
        int i = 20;
        while (i>=0){
            if((  (n>>i) & 1) ==1 ) flag = (builder.length()== 0 && builder.append(add(i)).length()>0)
                                        || (builder.append("+").append(add(i)).length()>0);

            i--;
        }
        //if(builder.charAt(builder.length()-1)=='+')builder.deleteCharAt(builder.length()-1);
        System.out.println(builder);
        //System.out.println(add(n));
    }

    private void init(){
        //table.put(0,"0");
          table.put(0,"2(0)");
          table.put(1,"2");
          table.put(2,"2(2)");
    }
    private String add(int n){

        if(table.containsKey(n)) return table.get(n);
        StringBuilder builder = new StringBuilder();
        boolean flag;
        int i = 20;
        while (i>=0){
            if(((n>>i) & 1) ==1 ) flag = (builder.length()== 0 && builder.append(add(i)).length()>0)
                    || (builder.append("+").append(add(i)).length()>0);

            i--;
        }
        //System.out.println(n+":"+builder);
        table.put(n,"2("+ builder+")");
        return "2("+ builder+")";
    }

    public static void main(String[] args) {
        new Main().solu();
    }
}

package oj.luogu.basically.P1003;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    int n;
    ArrayList<Node> list;
    Scanner scanner;
    int x,y;
    public Main(){
        scanner = new Scanner(System.in);
        n = scanner.nextInt();
        list = new ArrayList<>(n);
        int i = n,a,b;
        while (i-- >0){
            a = scanner.nextInt();
            b = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            list.add(new Node(a,b,x,y));
        }
        x = scanner.nextInt();
        y = scanner.nextInt();
    }

    public void choose(){
        int res = 0;
        Node node;
        for (int i=0;i<list.size();i++) {
            node = list.get(i);
            if(node.check(x,y))  res = i+1;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        new Main().choose();
    }
}
class Node{
    int a,b,x,y;
    public Node(int a,int b,int x,int y){
        this.a = a;
        this.b = b;
        this.x = x+a;
        this.y = y+b ;
    }
    public boolean check(int m,int n){
        return m >= a && m <= x && n >= b && n <= y;
    }
}
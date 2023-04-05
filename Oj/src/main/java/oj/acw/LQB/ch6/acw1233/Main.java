package main.java.oj.acw.LQB.ch6.acw1233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Main {
    int n;
    static final int N = 1010;
    char [][] maps = new char[N][N];
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
    boolean [][]v = new boolean[N][N];
    Node [] q = new Node [N*N];
    int total,bound;

    class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    void bfs(int i,int j){
        total = 0;
        bound = 0;
        Node node = new Node(i, j);
        int hh=0,tt=0;
        q[0] = node;
        boolean is_bound = false;
        v[i][j] = true;
        while(hh<=tt){
            Node t = q[hh++];
            is_bound = false;
            total++;
            for(int k =0;k<dx.length;k++) {
                int x = t.x+dx[k],y = t.y+dy[k];
                if (x < 0 || x >= n || y < 0 || y >= n) continue; 
                if(v[x][y]) continue;
                if(maps[x][y]=='.') {
                    is_bound = true;
                    continue;
                }
                q[++tt] = new Node(x, y);
                v[x][y] = true;
            }
            if(is_bound) bound++;
        }
        
       
    }
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    void solution()throws IOException{
        int cnt = 0;
        n = Integer.parseInt(reader.readLine().trim());
        for(int i=0;i<n;i++){
            maps[i] = reader.readLine().toCharArray();
        }
        for(int i=0;i<v.length;i++) Arrays.fill(v[i], false);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!v[i][j] && maps[i][j]=='#'){
                    
                    bfs(i,j);
                    if(total==bound) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
  
    public static void main(String[] args)throws IOException {
        Main main = new Main();
        main.solution();
    }
}
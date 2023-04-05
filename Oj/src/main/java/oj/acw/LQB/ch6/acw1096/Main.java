package oj.acw.LQB.ch6.acw1096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int l,r,c;
    ArrayList<char [][]> maps = new ArrayList<>();
    ArrayList<boolean [][]> visit = new ArrayList<>();
    int [] dx = {-1,0,0,1,0,0};
    int [] dy = {0,1,-1,0,0,0};
    int [] dz = {0,0,0,0,1,-1};
    class PII{
        public int l,r,c;
        public PII(int l,int r,int c){
            this.l = l;
            this.r = r;
            this.c = c;

        }
    }
    void bfs(PII start,PII end){
        Queue<PII> queue = new LinkedList<>();
        queue.offer(start);
        PII node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            for(int i = 0;i<dx.length;i++){
                int x=node.r+dx[i] , y = node.c+dy[i], z = node.l+dz[i];
                if(x<0 ||x>=r || y<0 || y>=c || z<0 || z>=l) continue;

            }
        }
    }
    void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            PII start = null,end = null;
            String[] split = reader.readLine().split(" ");
            l  = Integer.parseInt(split[0]);
            r = Integer.parseInt(split[1]);
            c = Integer.parseInt(split[2]);
            if(l==0 && r==0 && c==0) break;
            for(int i =0;i<l;i++){
                maps.add(new char[r+1][c+1]);
                for(int j=0;j<r;j++){
                    maps.get(i)[j]=  reader.readLine().toCharArray();
                    for(int k=1;k<=c && (start==null || end==null);k++){
                        if(maps.get(i)[j][k]=='S') {start = new PII(i,j,k);}
                        if(maps.get(i)[j][k]=='S') {end= new PII(i,j,k);}

                    }
                }
            }
        }


    }
}

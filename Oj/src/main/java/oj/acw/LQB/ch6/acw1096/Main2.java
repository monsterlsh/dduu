package oj.acw.LQB.ch6.acw1096;

import java.util.*;

public class Main2
{
    static final Scanner read=new Scanner(System.in);
    static final int N=110;
    static final int[] dx={-1, 1, 0, 0, 0, 0};
    static final int[] dy={0, 0, -1, 1, 0, 0};
    static final int[] dz={0, 0, 0, 0, -1, 1};

    static int h, n, m;
    static char[][][] g=new char[N][N][N];
    static Node st, ed;

    public static void main(String[] args)
    {
        while(true)
        {
            h=read.nextInt();
            n=read.nextInt();
            m=read.nextInt();
            if(h==0&&n==0&&m==0) break;

            for(int z=1;z<=h;z++)
                for(int x=1;x<=n;x++)
                {
                    String line=read.next();
                    for(int y=1;y<=m;y++)
                    {
                        g[z][x][y]=line.charAt(y-1);
                        if(g[z][x][y]=='S') st=new Node(z, x, y, 0);
                        else if(g[z][x][y]=='E') ed=new Node(z, x, y, 0);
                    }
                }

            int ans=bfs();
            if(ans==-1) System.out.println("Trapped!");
            else System.out.println("Escaped in "+ans+" minute(s).");
        }
    }

    static int bfs()
    {
        LinkedList<Node> q=new LinkedList<>();
        q.offer(st);

        while(q.size()>0)
        {
            Node t=q.peek();
            q.poll();
            if(t.z==ed.z&&t.x==ed.x&&t.y==ed.y) return t.dist;

            for(int i=0;i<6;i++)
            {
                int z=t.z+dz[i], x=t.x+dx[i], y=t.y+dy[i];
                if(z<1||z>h||x<1||x>n||y<1||y>m||g[z][x][y]=='#') continue;

                g[z][x][y]='#';
                q.offer(new Node(z, x, y, t.dist+1));
            }
        }

        return -1;
    }
}

class Node
{
    int z, x, y;
    int dist;

    public Node(int z, int x, int y, int dist)
    {
        this.z=z;
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}

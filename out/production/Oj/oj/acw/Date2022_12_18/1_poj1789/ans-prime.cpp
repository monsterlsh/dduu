#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>
using namespace std;
#define SIS std::ios::sync_with_stdio(false),cin.tie(0),cout.tie(0)
#define endl '\n'
const int MAXN = 2005;
const int inf = 0x3f3f3f3f;
int cost[MAXN][MAXN],mincost[MAXN];
bool vis[MAXN];
string s[MAXN];

int fun(int x,int y)
{
    int res=0;
    for(int i=0;i<7;i++)
        if(s[x][i]!=s[y][i])
            res++;
    return res;
}

int prim(int n)
{
    int res=0;
    memset(mincost,inf,sizeof(mincost));
    memset(vis,false,sizeof(vis));
    mincost[0]=0;
    while(true)
    {
        int v=-1;
        for(int i=0;i<n;i++)
            if(!vis[i] && (v==-1 || mincost[i]<mincost[v])) v=i;
        if(v==-1) break;
        vis[v]=true;
        res+=mincost[v];
        for(int i=0;i<n;i++)
            mincost[i]=min(mincost[i],cost[v][i]);
    }
    return res;
}

int main()
{
    SIS;
    int n;
    while(cin >> n, n)
    {
        for(int i=0;i<n;i++)
            cin >> s[i];
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                cost[i][j]=cost[j][i]=fun(i,j);
        cout << "The highest possible quality is 1/" << prim(n) << "." << endl;
    }
    return 0;
}

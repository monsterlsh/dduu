#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>
using namespace std;
#define SIS std::ios::sync_with_stdio(false),cin.tie(0),cout.tie(0)
#define endl '\n'
const int MAXN = 2e3+5;
const int inf = 0x3f3f3f3f;
int pre[MAXN];
string s[MAXN];

struct Node
{
    int u,v,w;
}node[MAXN*MAXN>>1];

void init(int n)
{
    for(int i=0;i<n;i++)
        pre[i]=i;
}

int _find(int x)
{
    if(pre[x]==x) return x;
    return pre[x]=_find(pre[x]);
}

bool unite(int x,int y)
{
    x=_find(x);
    y=_find(y);
    if(x==y) return false;
    pre[x]=y;
    return true;
}

int fun(int x,int y)
{
    int res=0;
    for(int i=0;i<7;i++)
        if(s[x][i]!=s[y][i])
            res++;
    return res;
}

bool compare(Node a,Node b)
{
    return a.w<b.w;
}

int kruskal(int n,int m)
{
    int res=0;
    init(n);
    sort(node,node+m,compare);
    for(int i=0;i<m;i++)
    {
        Node nd=node[i];
        if(unite(nd.u,nd.v))
            res+=nd.w;
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
        int num=0;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                node[num].u=i,node[num].v=j,node[num++].w=fun(i,j);
        cout << "The highest possible quality is 1/" << kruskal(n,num) << "." << endl;
    }
    return 0;
}

#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;

const int MAXN=1100000;
const int MAXM=105;
const int MOD=90;
int stone[MAXM];
int a[MAXN];
int f[MAXN];
int L,s,t;
int n;

void init()
{
    scanf("%d%d%d%d",&L,&s,&t,&n);
    for(int i=1;i<=n;i++)
        scanf("%d",&stone[i]);
}

void solve()
{
    int tot=0;
    for(int i=1;i<=n;i++)
        if(stone[i]%s==0)
            tot++;
    cout<<tot<<endl;
    exit(0);
}

void work()//处理石头~缩掉里面的空地
{
    sort(stone+1,stone+n+1);
    for(int i=1;i<=n;i++)
    {
        int dist=stone[i]-stone[i-1];
        stone[i]=stone[i-1]+dist%MOD;
    }
    L=(L-stone[n])%MOD+stone[n];
    for(int i=0;i<=n;i++)
        cout<<stone[i]<<",";
    cout<<endl;
    for(int i=1;i<=n;i++)
        a[stone[i]]=1;
}

void DP()
{
    memset(f,0x3f,sizeof(f));
    f[0]=0;
    for(int i=s;i<=L+t;i++)//第一次至少也会跳到s
        for(int j=s;j<=t;j++)
            if(i>=j)
                f[i]=min(f[i],f[i-j]+a[i]);
    int ans=(1<<30)-1;
    for(int i=L;i<=L+t;i++)
        ans=min(ans,f[i]);
    cout<<ans<<endl;
}

int main()
{
    init();
    if(s==t)//特判s==t
        solve();
    work();
    DP();
}
   

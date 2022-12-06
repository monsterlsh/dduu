//#include <bits/stdc++.h>
#include <cstdio>
#include <cstring>
using namespace std;
typedef long long LL;
int a[50],tol;
LL dp[50][50][50][2];
LL dfs(int cur,int sum0,int sum1,int limit,int have1)
{
    if(!cur)return sum0>=sum1?1:0;
    int up=limit?a[cur]:1;
    if(!limit&&dp[cur][sum0][sum1][have1]!=-1)return dp[cur][sum0][sum1][have1];
    LL ans=0;
    for(int i=0; i<=up; i++)
    {
        int dd0=i==0;
        int dd1=i==1;
        have1=have1||i==1;
        ans+=dfs(cur-1,sum0+have1*dd0,sum1+dd1,limit&&i==a[cur],have1);
    }
    if(!limit)dp[cur][sum0][sum1][have1]=ans;
    return ans;
}
LL solve(LL x)
{
    tol=0;
    while(x)
    {
        a[++tol]=x&1;
        x>>=1;
    }
    return dfs(tol,0,0,1,0);
}
int main()
{
    LL l,r;
    memset(dp,-1,sizeof(dp));
    scanf("%lld%lld",&l,&r);
    printf("%lld",solve(r)-solve(l-1));
    return 0;
}


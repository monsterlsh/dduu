#include <bits/stdc++.h>
using namespace std;
int a[10005],b[10005],t=0,n,m,dp[10005]={ },w,v,s;
int main()
{
    cin>>n>>m;
    while(n--)
    {
        cin>>v>>w>>s;
        while(s--)
        {
            a[++t]=v;
            b[t]=w;
        }//死拆，把多重背包拆成01背包
    }
    for(int i=1;i<=t;i++)
    for(int j=m;j>=a[i];j--)
    dp[j]=max(dp[j-a[i]]+b[i],dp[j]);//直接套01背包的板子
    cout<<dp[m]<<endl;
    return 0;
}

// 作者：9年级的蒟蒻
// 链接：https://www.acwing.com/solution/content/13873/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
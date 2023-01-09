#include<bits/stdc++.h>

using namespace std;
const int N=15;
const int M=12;
int f[N],d[N];
int main(){
    for(int i=1;i<=M;i++)
        d[i]=2*d[i-1]+1;
    memset(f,0x3f,sizeof(f));
    // 凡是用到min的都需要，赋较大值。
    // memset以字节形式重置(int: 0x3f3f3f3f)
    //又0x3f的2倍为最大整数,所以还可以满足加法不越界
    f[1]=1;
    for(int i=2;i<=M;i++)
        for(int j =1;j<i;j++)
            f[i]=min(f[i],2*f[j]+d[i-j]);
    for(int i=1;i<=M;i++)
        cout<<f[i]<<"\n";
    return 0;
}

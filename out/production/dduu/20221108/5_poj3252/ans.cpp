#include<iostream>
#include<algorithm>
#include<cstdio>
#include<cstring>
#define inf 0x3f3f3f3f
using namespace std;
typedef long long ll;
int c[33][33]={0};

void init()//组合数打表
{
    c[0][0]=1;
    for(int i=1;i<33;i++)
    {
        c[i][0]=1;
        for(int j=1;j<=i;j++)
            c[i][j]=c[i-1][j]+c[i-1][j-1];
    }
}

int count(int n)//寻找比n小符合条件个数 
{
    int d=0,zero=0,res=0;
    bool m[33]={0};
    while(n)// 转化为二进制,d计算 位数，m[]存每一位是0还是1
    {
        m[++d]=n%2;
        n/=2;
    }
    for(int i=2;i<d;i++)//计算二进制位数小于d的情况，（省略了位数为1，因为1不符合条件）
    {
        for(int j=(i+1)/2;j<i;j++)
            res+=c[i-1][j];
    }
    for(int i=d-1;i>=1;i--)//计算二进制位数等于于d的情况
    {
        if(m[i])
        {
            for(int j=(d+1)/2-(zero+1);j<i;j++)//遍历每种小于的情况 
                res+=c[i-1][j];
        }
        else
            zero++;
    }
    return res;
}

int main()
{
    int s,e;
    init();
    while(cin>>s>>e)
    {
        cout<<count(e+1)-count(s)<<endl;
    }
    return 0;
}
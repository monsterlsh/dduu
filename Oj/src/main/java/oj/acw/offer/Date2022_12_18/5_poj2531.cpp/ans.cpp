#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <set>
#include <queue>
#include <stack>
 
using namespace std;
const int inf=0x3f3f3f3f;
int map[40][40];
int g[40];
int n,res;
void dfs(int site,int sum)
{
    int i;
    g[site]=1;//取出
    int num=sum;
    for(i=0;i<n;i++){
        if(g[i]==1)//与site在一个集合里的点a
            num-=map[site][i];//减去他们之间的权值
        else//否则和site不在一个集合里
            num+=map[site][i];//加上他们之间的权值
    }
    res=max(res,num);//依次循环结束找到的最大值
    for(i=site+1;i<n;i++){//然后遍历剩下的点
        if(num>sum){//小剪枝，如果加入了点site后两个集合之间的权值小了，则就不需要遍历这个点。
            dfs(i,num);
            g[i]=0;
        }
    }
 
}
int main()
{
    int i,j;
    while(~scanf("%d",&n)){
        memset(map,0,sizeof(map));
        memset(g,0,sizeof(g));
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
            scanf("%d",&map[i][j]);
        res=-inf;
        dfs(0,0);
        printf("%d\n",res);
    }
    return 0;
}
#include<stdio.h>
#include<string.h>
#include<queue>
using namespace std;
struct path
{
    int x,y;
}a[121222];
int map[50][50];
int ans[50];
int map2[50][50];
int vis[50];
int n,m;
int degree[50];
int  floyd(int num)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            map2[i][j]=map[i][j];
        }
    }
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            for(int k=0;k<n;k++)
            {
                if(map2[j][i]==1&&map2[i][k]==1)
                {
                    map2[j][k]=1;
                }
            }
        }
    }
    for(int i=0;i<n;i++)
    {
        if(map2[i][i]==1)return -1;
    }
    int relation[50];
    memset(relation,0,sizeof(relation));
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(map2[i][j]==1)
            {
                relation[j]++;
                relation[i]++;
            }
        }
    }
    int i;
    for(i=0;i<n;i++)
    {
        if(relation[i]!=n-1)break;
    }
    if(i==n)return 1;
    return 0;
}
void solve(int num)
{
    memset(vis,0,sizeof(vis));
    queue<int >s;
    int cont=0;
    for(int i=0;i<n;i++)
    {
        if(degree[i]==0)
        {
            s.push(i);
            vis[i]=1;
            ans[cont++]=i;
        }
    }
    while(!s.empty())
    {
        int u=s.front();
        s.pop();
        for(int j=0;j<n;j++)
        {
            if(map[u][j]==1&&vis[j]==0)
            {
                degree[j]--;
                if(degree[j]==0)
                {
                    s.push(j);
                    ans[cont++]=j;
                    vis[j]=1;
                }
            }
        }
    }
    printf("Sorted sequence determined after %d relations: ",num+1);
    for(int i=0;i<cont;i++)
    {
        printf("%c",ans[i]+'A');
    }
    printf(".\n");
}
int main()
{
    while(~scanf("%d%d",&n,&m))
    {
        if(n==0&&m==0)break;
        memset(map2,0,sizeof(map2));
        memset(degree,0,sizeof(degree));
        memset(map,0,sizeof(map));
        for(int i=0;i<m;i++)
        {
            char tmp[10];
            scanf("%s",tmp);
            int u=tmp[0]-'A';
            int v=tmp[2]-'A';
            a[i].x=u;
            a[i].y=v;
        }
        int i;
        for(i=0;i<m;i++)
        {
            int u=a[i].x;int v=a[i].y;
            map[u][v]=1;
            degree[v]++;
            int tmp=floyd(i);
            if(tmp==-1)
            {
                printf("Inconsistency found after %d relations.\n",i+1);
                break;
            }
            if(tmp==1)
            {
                solve(i);
                break;
            }
        }
        if(i==m)
        {
            printf("Sorted sequence cannot be determined.\n");
        }
    }
}
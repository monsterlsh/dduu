#include <iostream>
using namespace std;

const int N=20;

int n;

bool vis[N]; //判断选还是不选

void DFS(int u) //第几层就是筛选第几个数字
{
    if(u>n) //不可以有等号，如果有等号会少一层递归，即最后一层无法递归
    {
        for(int i=1;i<=n;i++)//从1到n选择
        if(vis[i])  //把选择的数打印出来
            cout<<i<<" ";
        cout<<endl;
        return ;
    }
    else {
        vis[u]=true;//选这个数字
        DFS(u+1);

        vis[u]=false;//不选这个数字
        DFS(u+1);
    }
}
int main() {
    cin>>n;
    DFS(1);  //从1开始选择，到n结束，所以不能从0开始；
    return 0;
}

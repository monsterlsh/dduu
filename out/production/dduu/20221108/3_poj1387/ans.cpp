#include <iostream>
#include <cstring>
using namespace std;
int n,m;//n个位置，m个钩码 
int place[21];//因为钩码数量最多为20 ，存放钩码位置 
int w[21];//钩码数量 
int dp[21][15000];//dp[i][j],i为钩码数量，j为平衡点，整体说的是这种状况的个数  
int main()
{ 
 
    memset(dp,0,sizeof(dp));
	cin>>n>>m;
	for(int i=0;i<n;i++) 
	cin>>place[i];
	for(int i=0;i<m;i++) 
	cin>>w[i];
	dp[0][7500]=1;//若是不放任何东西，即处于平衡处，状况个数为1
	//一个一个放东西 
	for(int i=1;i<=m;i++)
	 {
	   for(int j=0;j<=15000;j++)
	    {
		 if(dp[i-1][j])//从可以计算的数字开始 
	       {
		     for(int k=0;k<n;k++)
	         dp[i][j+place[k]*w[i-1]] +=dp[i-1][j];
	        }
	    }
     }
	cout<<dp[m][7500]<<endl;
	    
	return 0;
}
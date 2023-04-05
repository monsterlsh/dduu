//认真看，杜绝抄袭
//好好消化一下，这题很经典
//记忆化搜索/递归 做法
#include<cstdio>
#define MAX_N 20
#define ll long long
using namespace std;
int n;
ll f[MAX_N][MAX_N];
ll dfs(int i,int j)
{
	if(f[i][j]) return f[i][j];
	if(i==0)return 1; //边界
	if(j>0) f[i][j]+=dfs(i,j-1);
	f[i][j]+=dfs(i-1,j+1);
	return f[i][j];
}
int main()
{
	scanf("%d",&n);
	printf("%lld",dfs(n,0));
	return 0;
}

//递归转递推  递推做法
#include<cstdio>
#define MAX_N 20
#define ll long long
using namespace std;
int n;
ll f[MAX_N][MAX_N];
int main()
{
	scanf("%d",&n);
	for(int i=0;i<=n;i++)
	{
		f[0][i]=1;
	}
	for(int i=1;i<=n;i++)
	{
		for(int j=i;j<=n;j++)
		{
			if(i==j)f[i][j]=f[i-1][j];
			else f[i][j]=f[i][j-1]+f[i-1][j];
		}
	}
	printf("%lld",f[n][n]);
	return 0;
}

//数论做法 卡特兰数
//公式1：
#include<cstdio>
#define MAX_N 20
#define ll long long
using namespace std;
int n;
ll f[MAX_N];
int main()
{
	f[0]=f[1]=1;
	scanf("%d",&n);
	for(int i=2;i<=n;i++)
	{
		for(int j=0;j<i;j++)
		{
			f[i]+=f[j]*f[i-j-1];
		}
	}
	printf("%lld",f[n]);
	return 0;
}

//公式2：
#include<cstdio>
#define MAX_N 20
#define ll long long
using namespace std;
int n;
ll f[MAX_N];
int main()
{
	f[0]=f[1]=1;
	scanf("%d",&n);
	for(int i=2;i<=n;i++)
	{
		f[i]+=f[i-1]*(4*i-2)/(i+1);
	}
	printf("%lld",f[n]);
	return 0;
}

//公式3：
#include<cstdio>
#define MAX_N 20
#define ll long long
using namespace std;
int n;
ll c[MAX_N*2][MAX_N];
int main(){

    scanf("%d",&n);
    for(int i=1;i<=2*n;i++)
    {
    	c[i][0]=c[i][i]=1;
    	for(int j=1;j<i;j++)
    	{
    		c[i][j]=c[i-1][j]+c[i-1][j-1];
		}
	}
    printf("%lld",c[2*n][n]/(n+1));
    return 0;
}

//公式4：
#include<cstdio>
#define MAX_N 20
#define ll long long
using namespace std;
int n;
ll c[MAX_N*2][MAX_N];
int main(){

    scanf("%d",&n);
    for(int i=1;i<=2*n;i++)
    {
    	c[i][0]=c[i][i]=1;
    	for(int j=1;j<i;j++)
    	{
    		c[i][j]=c[i-1][j]+c[i-1][j-1];
		}
	}
    printf("%lld",c[2*n][n]-c[2*n][n-1]);
    return 0;
}

//高精/打表：
#include<iostream>
#include<cstdio>
#include<cstring>
#define MAX_N 110
using namespace std;
int f[MAX_N][MAX_N],c[MAX_N];
inline int len(int a[])
{
    int i;
    for(i=60;i>=0;i--)//想要100个以上，这个i的范围要改
    {
    	if(a[i]!=0) break;
	}
    return i;
}
inline void add(int a[],int b[],int w)//高精加法
{
    int lena=len(a),lenb=len(b);
    for(int i=0;i<=max(lena,lenb);i++)
    {
    	f[w][i]=a[i]+b[i];
	}
    for(int i=0;i<=max(lena,lenb)+1;i++)
	{
        f[w][i+1]+=f[w][i]/10;
        f[w][i]%=10;
    }
}
inline void Catalan(int a[],int b[])//卡特兰
{
    memset(c, 0, sizeof(c));
	int lena=len(a),lenb=len(b);
    for (int i=0;i<=lena;i++){
    	for (int j=0;j<=lenb;j++)
    		c[i+j]+=a[i]*b[j];
	}
    for (int i=0;i<=lena+lenb+1;i++)
	{
        c[i+1]+=c[i]/10;
        c[i]%=10;
    }
}
int main()
{
    //int k;
    freopen("Catalan.txt","w"stdin);//文件操作;
    f[0][0]=f[1][0]=1;
    for (int i=2;i<=100;i++)//同理，要多输出几个i就等于几
    {
    	for (int j=0;j<i;j++)
		{
            Catalan(f[j], f[i-j-1]);
            add(f[i],c,i);
        }
	}
    for(int i=1;i<=100;i++)//输出 卡特兰数 1-100，范围同上，要输出几个自己改
    {
	    for (int j=len(f[i]);j>=0;j--)
	    {
	    	//printf("%d",f[i][j]);
			putchar((char)f[i][j]+'0');//比printf稍快?
		}
		printf("\n");
	}
    return 0;
}
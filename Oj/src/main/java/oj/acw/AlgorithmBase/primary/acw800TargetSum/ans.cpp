#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int N[100001],m[100001];
int main()
{
    int n,a,B,j=0,i=0;
    cin>>n>>a>>B;
    for(int i=1;i<=n;i++)cin>>N[i];
    j=n;
    for( i=1;i<=a;i++)//输入优化
    {
        cin>>m[i];
       while(j>0&&N[j]+m[i]>B)j--; //while循环j第一次还是当前位置
       if(N[j]+m[i]==B)
       return cout<<j-1<<" "<<i-1,0;//我从一枚举的
    }
    return 0;
}
//
//作者：吴子涵
//链接：https://www.acwing.com/solution/content/60103/
//来源：AcWing
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
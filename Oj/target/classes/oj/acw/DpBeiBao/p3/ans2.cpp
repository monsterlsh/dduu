#include<iostream>
using namespace std;
const int N = 1010;
int f[N];
int v[N],w[N];
int main()
{
    int n,m;
    cin>>n>>m;
    for(int i = 1 ; i <= n ;i ++)
    {
        cin>>v[i]>>w[i];
    }

    for(int i = 1 ; i<=n ;i++)
    for(int j = v[i] ; j<=m ;j++)
    {
            f[j] = max(f[j],f[j-v[i]]+w[i]);
    }
    cout<<f[m]<<endl;
}

// 作者：Charles__
// 链接：https://www.acwing.com/solution/content/5345/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
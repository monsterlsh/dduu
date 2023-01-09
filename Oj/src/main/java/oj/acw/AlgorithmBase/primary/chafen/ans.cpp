#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;
const int N = 100005;
int a[N],b[N],sum[N];
int main()
{
    int n,m;
    cin >> n >> m;
    for(int i = 1; i <= n; i++)
    {
        cin >> a[i];
    }
    for(int i = 1; i <= m; i++)
    {
        int l,r,c;
        cin >> l >> r >> c;
        b[l] += c;
        b[r+1] -= c;
    }
    for(int i = 1; i <= n; i++)
    {
        sum[i] = sum[i-1] + b[i];
    }
    for(int i = 1; i <= n; i++)
    {
        cout << sum[i] + a[i] << " ";
    }
}
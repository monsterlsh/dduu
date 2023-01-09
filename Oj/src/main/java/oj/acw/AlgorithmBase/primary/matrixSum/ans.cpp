#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;
const int N = 1005;
int a[N][N],sum[N][N];
int main()
{
    int n,m,q;
    cin >> n >> m >> q;
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= m; j++)
        {
            cin >> a[i][j];
            sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + a[i][j];
        }

    }
    while(q--)
    {
        int x1,x2,y1,y2;
        cin >> x1 >> y1 >> x2 >> y2;
        cout << sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1] << endl;
    }


    return 0;
}
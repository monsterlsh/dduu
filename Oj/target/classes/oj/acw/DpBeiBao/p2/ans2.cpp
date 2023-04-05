#include<bits/stdc++.h>

using namespace std;

const int MAXN = 1005;
int f[MAXN];  // 

int main() 
{
    int n, m;   
    cin >> n >> m;

    for(int i = 1; i <= n; i++) {
        int v, w;
        cin >> v >> w;      // 边输入边处理
        for(int j = m; j >= v; j--)
            f[j] = max(f[j], f[j - v] + w);
    }

    cout << f[m] << endl;

    return 0;
}

// 作者：深蓝
// 链接：https://www.acwing.com/solution/content/1374/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
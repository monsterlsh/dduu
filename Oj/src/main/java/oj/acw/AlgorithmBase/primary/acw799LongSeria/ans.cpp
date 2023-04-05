# include <iostream>
using namespace std;

const int N = 100010;
int a[N], s[N];

int main()
{
    int n, r = 0;
    cin >> n;

    for (int i = 0, j = 0; i < n; ++ i)
    {
        cin >> a[i];
        ++ s[a[i]];
        while (s[a[i]] > 1) -- s[a[j++]]; // 先减次数后右移
        r = max(r, i - j + 1) ;
    }
    cout << r;

    return 0;
}
//
//作者：Alicia编程果果
//链接：https://www.acwing.com/solution/content/6460/
//来源：AcWing
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
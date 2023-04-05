#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

// C = A + B;
string add(const string& A, const string& B)
{
    string C;
    int t = 0;
    for (int i = A.size()-1, j = B.size()-1; i >= 0 || j >= 0 || t > 0; i--, j--)
    {
        if (i >= 0) t += (A[i] - '0');
        if (j >= 0) t += (B[j] - '0');
        C += ((t % 10) + '0');
        t /= 10;
    }

    reverse(C.begin(), C.end());
    return C;
}

int main()
{
    ios::sync_with_stdio(false);
    string A, B;
    cin >> A >> B;
    cout << add(A, B) << endl;
    return 0;
}
//
//作者：二月
//链接：https://www.acwing.com/solution/content/5692/
//来源：AcWing
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
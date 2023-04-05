#include <iostream>
#include <vector>
#include <set>
#include <unordered_set>
#include <climits>
#include<algorithm>
using namespace std;
unordered_set<int> ss;
unordered_set<int> repeat;

void fn(int n)
{
    if (ss.empty() || ss.size() == 1)
        return;

    int pre = repeat.size();
    repeat.emplace(n);
    int aft = repeat.size();
    if (aft == pre)
        return;
    pre = aft;
    do
    {
        n = n % 2 != 1 ? n >> 1 : (3 * n + 1) >> 1;
        ss.erase(n);
        repeat.emplace(n);
        aft = repeat.size();
        if (aft == pre)
            break;
        pre = aft;
    } while (n > 1);
}
int main()
{

    int n;
    cin >> n;
    int tmp;
    for (int i = 0; i < n; i++)
    {
        cin >> tmp;
        ss.emplace(tmp);
    }
    int i = 0;
    for (auto iter = ss.begin(); iter != ss.end(); iter++, i++)
        fn(*iter);
    i = 0;
    n = ss.size();
    vector<int> arr(n);
    if (!ss.empty())
    {
        for (auto iter = ss.begin(); iter != ss.end(); iter++, i++)
        {
            arr[i] = *iter;
        }
        sort(arr.begin(),arr.end());
        i--;
        for (int j = i; j >0; j--)
        {
            cout << arr[j] << " ";
        }
        cout << arr[0] << endl;
    }
}

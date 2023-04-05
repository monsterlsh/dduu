#include <iostream>
#include <vector>
using namespace std;
vector<int> arr;
void input()
{
    //freopen("input.in", "r", stdin);
    int n;
    while (scanf("%d", &n) != EOF)
    {
        arr.emplace_back(n);
    }
}
void process()
{
    if (arr.empty())
        return;
    int i = 1, d = 0;
    while (i < arr.size())
    {
        arr[i - 1] = arr[i] * arr[i - 1];
        arr[i] = arr[i] == 0 ? 0 : arr[i] - 1;
        i += 2;
    }
    for (i = 0; i < arr.size(); i += 2)
    {
        if (arr[i] == 0 && arr[i + 1] == 0)
            d += 2;
        if (i + d + 1 < arr.size())
        {
            arr[i] = arr[i + d];
            arr[i + 1] = arr[i + 1 + d];
        }
    }
     if(arr.size()-d>0)
    arr.resize(arr.size() - d);
    else arr.clear();
}
void printArray(const vector<int> &arr)
{
    if(arr.empty()){
        cout<<0<<" "<<0<<endl;
        return;
    }
    int i = 0;
    for (; i < arr.size() - 1; i++)
        cout << arr[i] << " ";
    if (i < arr.size())
        cout << arr[i] << endl;
}
int main()
{
    input();
    process();
    printArray(arr);
}
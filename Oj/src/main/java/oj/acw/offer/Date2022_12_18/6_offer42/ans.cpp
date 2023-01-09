#include <iostream>

using namespace std;

const int kLen = 6;

// eg. A[5] = {1,2,3,4,5};
// S[0] = 0;  S[1] = S[0] + 1;  S[2] = S[1] + 2

int main()
{
    int A[kLen] = {1, 2, -1, -4, 3, 6};
    int ans = A[0];        //初始化答案为第一个元素
    int S[kLen + 1] = {0}; // S[0] = 0
    for (int i = 1; i <= kLen; i++)
        S[i] = S[i - 1] + A[i - 1]; //递推求得每个位置的前缀和。

    for (int i = 1; i <= kLen; i++)
    {
        for (int j = i; j <= kLen; j++)
        {
            int sum = S[j] - S[i - 1];
            if (sum > ans)
                ans = sum;
        }
    }
    cout << ans << endl;

    return 0;
}

int maxsum(int *A, int x, int y)
{ //返回数组在左闭右开区间[x,y)中的最大连续和
    int v, L, R, maxs;
    if (y - x == 1)
        return A[x];                                  //只有一个元素，直接返回 
    int m = x + (y-x)/2; //分治第一步:划分成[x, m)和[m, y)
    int maxs = max(maxsum(A, x, m), maxsum(A, m, y)); //分治第二步:递归求解
    int v, L, R;
    v = 0;
    L = A[m - 1]; //分治第三步:合并(1)——从分界点开始往左的最大连续和L
    for (int i = m - 1; i >= x; i--)
        L = max(L, v += A[i]);
    v = 0;
    R = A[m];                //分治第三步:合并(2)——从分界点开始往右的最大连续和R for(int i = m; i < y; i++) R = max(R, v += A[i]);
    return max(maxs, L + R); //把子问题的解与L和R比较
}
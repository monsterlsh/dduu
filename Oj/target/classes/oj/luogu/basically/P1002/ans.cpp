#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
#define ll long long
using namespace std;

// 快速读入
template <class I>
inline void read(I &num){
    num = 0; char c = getchar(), up = c;
    while(!isdigit(c)) up = c, c = getchar();
    while(isdigit(c)) num = (num << 1) + (num << 3) + (c ^ '0'), c = getchar();
    up == '-' ? num = -num : 0; return;
}
template <class I>
inline void read(I &a, I &b) {read(a); read(b);}
template <class I>
inline void read(I &a, I &b, I &c) {read(a); read(b); read(c);}

const int fx[] = {0, -2, -1, 1, 2, 2, 1, -1, -2};
const int fy[] = {0, 1, 2, 2, 1, -1, -2, -2, -1};

int bx, by, mx, my;
ll f[40];   //这次只需要一维数组啦
bool s[40][40];

int main(){
    read(bx, by); read(mx, my);
    bx += 2; by += 2; mx += 2; my += 2;
    f[2] = 1;   //初始化
    s[mx][my] = 1;
    for(int i = 1; i <= 8; i++) s[mx + fx[i]][my + fy[i]] = 1;
    for(int i = 2; i <= bx; i++){
        for(int j = 2; j <= by; j++){
            if(s[i][j]){
                f[j] = 0; // 还是别忘了清零
                continue;
            }
            f[j] += f[j - 1];
            //全新的 简洁的状态转移方程
        }
    }
    printf("%lld\n", f[by]);
    return 0;
}
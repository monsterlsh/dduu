#include<iostream>
using namespace std;
class Solution {
public:
    int digitAtIndex(int n) {
        if(n<10)return n;
        unsigned long width = 1,ten=10,pos=9,ws=9;
        while (ws < n)
        {
            width++;
            ten*=10;
            pos = ten-ten/10;
            ws += width*pos;
        }
        if(ws==n) return 9;
        ws-= width*pos;
        pos = ten-ten/10;
        ten = (n-ws)/width;
        pos = pos+ten;
        n = (n-ws)%width;
        if(n==0)return pos%10;
        pos+=1;
        n = width-n;
        while(n--){
            pos /=10;
        }
        return pos%10;
    }
    int digitAtIndex2(int n) {
         long long i = 1, s = 9, base = 1;//i表示是几位数，s表示位数共有多少个，base表示位数的起始值。
         while(n > i * s) {   // 9, 90, 900, 9000, 90000, i * s表示位数总共占多少位。
             n -= i * s;         // 1000 - 9 - 90 * 2 - 900 * 3 ,当i= 3 时不符合条件，说明是在三位数里面。
             i ++;                
             s *= 10;
             base *= 10;
         }
         int number = base + (n + i - 1) / i - 1; //求位数的第几个数， 1000 - 9 - 180 = n , n / 3 + base - 1（考虑0故减1）, 向上取整 n + i - 1。
         int r = n % i ? n % i : i;              // 除不尽就是第几位，除尽力了就是最后一位。
         for (int j = 0; j < i - r; j ++) number /= 10; //求数的第i - r位，取出第i - r位。

         return number % 10;
    }
};
int main(){
    Solution s;
    cout<<s.digitAtIndex(13)<<endl;;
}
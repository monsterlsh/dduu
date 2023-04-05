#include <iostream>
#include <cstdio>
#define ll long long
using namespace std;
int main(){
    ll a = 3101886402615264;
    ll ans = 68162760049436924;
    ll c = 133223633696258584;
    cout<<(ans%c)*(a%c) %c<<endl;
}
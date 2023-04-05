#include <iostream>
#include <cstdio>
#define ll long long
using namespace std;


unsigned long long a, b, p, c;
void solu2(){
    cin >> a >> b >> p, cout << (long long) ((__int128) a * b % p);
}

void solu3(){
    cin >> a >> b >> p, c = (long double) a * b / p, cout << a * b - c * p;
}

int main()
{
    ll a,b,p,res;
    cin>>a>>b>>p;
    res=0;
    int i = 0;
    while(b)
    {
        if(b&1){
            res=(res+a)%p;
            cout<<"i="<< i++<<"; ans = "<<res<<endl;
        }
            
        b>>=1;
        a=2*a%p;
        cout<<"i="<< i++<<"; a = "<<a<<endl;
    }
    cout<<res<<endl;
    return 0;
}

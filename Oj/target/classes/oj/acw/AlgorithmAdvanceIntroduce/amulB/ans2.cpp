#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
#define ll long long
vector<ll> mul(vector<ll> &a, ll &b){
    vector<ll> c;
    ll t = 0;
    for (ll i = 0; i < a.size() || t > 0; i++){
        if(i < a.size())
        {
            t += a[i] * b;
        }
        c.push_back(t % 10);
        t /= 10;
    }
    while(c.size() > 1 && c[c.size() - 1] == 0) c.pop_back();
    return c;
}
vector<ll> div(vector<ll> &a, ll &b, ll &r){
    vector<ll> c;
    r = 0;
    for(ll i = a.size() - 1; i >= 0; i--){
        r = r * 10 + a[i];
        c.push_back(r / b);
        r %= b;
    }
    reverse(c.begin(), c.end());
    while(c.size() > 1 && c[c.size() - 1] == 0) c.pop_back();
    return c;
}
vector<ll> a;
ll b=413715569939057660, r, p=133223633696258584;
string s = "250182048980811753";
int main(){
    //cin >> s >> b >> p;
    for(ll i = s.size() - 1; i >= 0; i--) a.push_back(s[i] - '0');
    vector<ll> c = mul(a, b);
    for(int i=c.size()-1;i>=0;i--)
        cout<<c[i];
    cout<<endl;
    div(c, p, r);
    cout << r;
    return 0;
}

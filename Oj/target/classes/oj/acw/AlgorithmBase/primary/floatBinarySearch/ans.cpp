#include<iostream>
#include<iomanip>
using namespace std;
double n,l,r,mid;
bool flag;
double q(double a){return a*a*a;}
int main(){
    cin>>n;
    l=-10000,r=10000;
    while(r-l>=1e-7){
        mid=(l+r)/2;
        if(q(mid)>=n) r=mid;
        else l=mid;
    }
    cout<<fixed<<setprecision(6)<<l;
    return 0;
}
//
//作者：第一WA者金银花
//链接：https://www.acwing.com/solution/content/3564/
//来源：AcWing
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
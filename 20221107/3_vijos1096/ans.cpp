#include<iostream>
using namespace std;
int a[13];
int main()
{
    int sum=0,sum2=0;
    for(int i=0;i<12;i++)
    {
        cin>>a[i];
    }
    for(int i=0;i<12;i++)
    {
        sum+=300;
        sum-=a[i];
        if(sum<0)
        {
            cout<<"-"<<i+1<<endl;
            return 0;
        }
        sum2+=sum/100*100;
        sum%=100;
    }
    cout<<sum+sum2*1.2<<endl;
    return 0;
}

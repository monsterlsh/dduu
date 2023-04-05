#include<iostream>

using namespace std;

long long n,k,a[1010],i,ans;

long long pow(long long a,long long b)
{
	long long res=1;
	while(b)
        {
	  if(b&1)  res*=a;
          a*=a,b>>=1;
        }
	return  res;
}

int main()
{
	cin>>k>>n;

	while(n)
        {
	   a[i]=n%2;
           n/=2,i++;
        }

	for(long long j=0;j<i;j++)
	  if(a[j])  ans+=pow(k,j);

	cout<<ans<<endl;
	return 0;
}
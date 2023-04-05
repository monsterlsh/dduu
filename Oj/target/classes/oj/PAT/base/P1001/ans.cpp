#include<iostream>
using namespace std;
 int main()
 {
     int n, step=0;
     while(scanf("%d",&n)==1)
     {
         step = 0;
         while(n>=1)
         {
            if(n==1) {
                cout<<step<<endl;
                break;
            }
            if(n%2==0)
            {
                n /= 2;
                step++;
            }
            else
            {
                n = (3*n+1)/2;
                step++;
            }
         }

     }
     return 0;
 }
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;
typedef long long LL;
typedef unsigned long long ULL;
const ULL base=10000;
 
char s[300],c[]={'0','1','2','3','4','5','6','7','8','9'};
char t[1000];
int sizes = 0;
ULL Hash,hashh,hasht,dt=1,ans=1,head=1,tail;
ULL Tp[]={1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000,10000000000,100000000000,1000000000000,100000000000000};
int main(){
    scanf("%s",s);int len=strlen(s);
    for(int i=0;i<len;i++)
        Hash=Hash*base+s[i],dt*=base;
    ULL num=0;bool first=true;
    while(true){
        while(sizes<=len){
            num++;
            int pow=0;
            while(Tp[pow]<=num)pow++;
            while(pow){
                pow--;
                int n=(num/Tp[pow])%10;
                tail=(tail+1)%512;
                t[tail]=c[n];sizes++;
            }
        }
        if(first){
            for(int i=1;i<=len;i++)
                hasht=hasht*base+t[i];
            if(hasht==Hash)break;
            first=false;
        }
        hashh=hashh*base+t[head];
        hasht=hasht*base+t[head+len];
        head=(head+1)%512;ans++;sizes--;
        if(Hash==hasht-hashh*dt)break;
    }
    printf("%lld",ans);
    return 0;
}
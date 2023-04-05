#include<iostream>
using namespace std;
bool judge(int n);
void pat1007();

int main(){
    pat1007();
}
bool judge(int n){
    for(int i=2;i*i<=n;i++){
        if(n%i==0)return false;
    }
    return true;
}
void pat1007(){
    int n;
    scanf("%d",&n);
    int pre=3,end=pre+2,res=0;
    //bool odd = true;
    while(end<=n){
        if(judge(end)){
            if(end == pre+2) res++;
            pre = end;
        }
        end += 2;
    }
    cout<<res<<endl;
}
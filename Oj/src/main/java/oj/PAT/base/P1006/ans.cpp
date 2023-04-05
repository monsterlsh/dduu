#include<iostream>
using namespace std;
int main(){
    int n,i=0;
    string str="";
    scanf("%d",&n);
    string s2(10,'S');
    string s3(10,'B');
    while(n){
        int tmp = n%10;
        n /= 10;
        switch (i)
        {
        case 0:for(int i=1;i<=tmp;i++) str+=i+'0';
            break;
        case 1:str= s2.substr(0,tmp)+str;break;
        case 2:str= s3.substr(0,tmp)+str;break;
        }
        i++;
    }
    cout<<str<<endl;
}
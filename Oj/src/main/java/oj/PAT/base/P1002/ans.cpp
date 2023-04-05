#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;
char ch[15][5]= {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};

int main(){

 char s[10000];
    scanf("%s",s);
    int len=strlen(s);
    int sum=0;
    for(int i=0;i<len;i++)
    {
       sum+=s[i]-'0';
    }
    //printf("sum=%d\n",sum);
    int a[1000];
    int q=0;
    while(sum!=0)
    {
        a[q]=sum%10;
        q++;
        sum=sum/10;
    }
    for(int j=q-1;j>=0;j--)
    {
        printf("%s",ch[a[j]]);
        if(j!=0)
            printf(" ");
    }
    printf("\n");
    return 0;
}
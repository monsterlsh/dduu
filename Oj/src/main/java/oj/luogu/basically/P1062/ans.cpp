#include<cstdio>
int k,n;
long long ans,base=1;
int main(){
	scanf("%d%d",&k,&n);
    /**********************************/
	while(n){
		if(n&1)ans+=base;//跟快速幂只有这里不一样
		base*=k;
		n>>=1;
	}
    /**********************************/
	printf("%d",ans);
	return 0;
}
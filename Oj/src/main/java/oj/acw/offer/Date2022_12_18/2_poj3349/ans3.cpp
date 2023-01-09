#include<iostream>
#include<stdio.h>
#include<string.h>
using namespace std;
typedef unsigned long long ull;
const int N=1e5+3;
const int HASH=1e6+7,MAXN=1e5+7;
struct HASHMAP{//Hash表
	int head[HASH],next[MAXN],size;
	ull state[MAXN];
	void init(){size=0;memset(head,-1,sizeof(head));}
	int insert(ull val){
		int h=val%HASH;
		for(int i=head[h];~i;i=next[i])if(val==state[i])return 1;
		state[size]=val;
		next[size]=head[h];
		head[h]=size++;
		return 0;
	}
}H;
int P[13],Q[13],R[13];
ull p=13331,pp,Hash[13],pm[13];
ull getseg(int l,int r){
	return Hash[r]-Hash[l-1]*(pm[r-l+1]);
}
bool C(int i,int j,int n,int P[]){
	int l=1,r=n;
	while(l<r){
		int mid=(l+r)>>1;
		if(getseg(i,i+mid-1)==getseg(j,j+mid-1))l=mid+1;
		else r=mid;
	}
	return P[i+l-1]>P[j+l-1];
}
int minpos(int P[],int n){//二分hash找最小表示法
	for(int i=1;i<=n;++i)P[i+n]=P[i];
	for(int i=1;i<=n<<1;++i)Hash[i]=Hash[i-1]*p+P[i];
	int i=1,j=n;
	while(i<j){
		if(C(i,j,n,P))++i;
		else --j;
	}
	return i;
}
int n,ok;
int main(){
	pm[0]=1;
	for(int i=1;i<=12;++i)pm[i]=pm[i-1]*p;
	scanf("%d",&n);
	H.init();
	while(n--){
		for(int i=1;i<=6;++i)scanf("%d",&P[i]),Q[7-i]=P[i];
		if(ok)continue;
		int k=minpos(P,6),m=minpos(Q,6),f=0;
		ull has=0;
		for(int i=0;i<6;++i)
			if(P[i+k]>Q[i+m]){f=1;break;}
			else if(P[i+k]<Q[i+m])break;
		for(int i=1;i<=6;++i)R[i]=f?Q[i+m-1]:P[i+k-1];
		for(int i=1;i<=6;++i)has=has*p+R[i];
		if(H.insert(has))ok=1;
	}
	if(ok)return puts("Twin snowflakes found.");
	puts("No two snowflakes are alike.");
	return 0;
}

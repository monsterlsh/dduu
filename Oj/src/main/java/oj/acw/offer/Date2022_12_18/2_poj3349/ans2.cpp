#include<iostream>
#include<set>
#include<algorithm>
#include<cstring>
#define ll long long 
using namespace std;
const int INF=0x3f3f3f3f;
const int maxn = 1e5+10;
const int P = 99991;
int n,num,snow[maxn][6],head[maxn],NEXT[maxn];
int Hash(int *a){
	int ant=0;
	for(int i=0;i<6;i++){
		ant=ant^a[i];
	}
	return ant%P;
}
bool equal(int *a,int *b){
	for(int i=0;i<6;i++){
		for(int j=0;j<6;j++){
			bool eq=1;
			for(int k=0;k<6;k++){
				if(a[(i+k)%6]!=b[(j+k)%6]){
					eq=0;
					break;
				}
			}
			if(eq) return true;
			eq=1;
			for(int k=0;k<6;k++){
				if(a[(i+k)%6]!=b[(j-k+6)%6]){
					eq=0;
					break;	
				}
			}
			if(eq) return true;
		}
	}
	return false;
}
bool insert(int *a){
	int val = Hash(a);
	for(int i=head[val];i!=0;i=NEXT[i]){
		if(equal(snow[i],a)) return 1;
	}
	++num;
	memcpy(snow[num],a,6*sizeof(int));
	NEXT[num]=head[val];
	head[val]=num;
	return 0;
}
int main(){
	scanf("%d",&n);
	for(int i=1;i<=n;i++){
		int a[10];
		for(int j=0;j<6;j++){
			scanf("%d",&a[j]);
		}
		if(insert(a)){
			cout<<"Twin snowflakes found."<<endl;
			return 0;
		}
	}
	cout<<"No two snowflakes are alike."<<endl;
	return 0;
}


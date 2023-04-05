#include <vector>
#include <cstdio>
#include <cstring>
#include <algorithm>
#define fo(i,a,b) for(int i=a;i<=b;i++)
#define fd(i,a,b) for(int i=a;i>=b;i--)
#define mp(a,b) make_pair(a,b)
using namespace std;

typedef long long ll;

int read() {
	char ch;
	for(ch=getchar();ch<'0'||ch>'9';ch=getchar());
	int x=ch-'0';
	for(ch=getchar();ch>='0'&&ch<='9';ch=getchar()) x=x*10+ch-'0';
	return x;
}

void write(ll x) {
	if (!x) {puts("0");return;}
	if (x<0) {x=-x;putchar('-');}
	char ch[20];int tot=0;
	for(;x;x/=10) ch[++tot]=x%10+'0';
	fd(i,tot,1) putchar(ch[i]);
	puts("");
}

const int N=5e4+5,M=505;
const ll inf=1e15;

int q,Mod;

struct Stack{
	int top;
	ll f[N][M];
	pair<int,int> a[N];
	void pre() {top=0;fo(i,1,Mod-1) f[0][i]=-inf;}
	void push(int w,int v) {
		w%=Mod;a[++top]=mp(w,v);
		fo(i,0,Mod-1) f[top][i]=max(f[top-1][i],f[top-1][(i-w+Mod)%Mod]+v);
	}
}L,R;

pair<int,int> d[N];

void rebuild() {
	int cnt=0;
	fd(i,L.top,1) d[++cnt]=L.a[i];
	fo(i,1,R.top) d[++cnt]=R.a[i];
	int pos=cnt/2;L.top=R.top=0;
	fd(i,pos,1) L.push(d[i].first,d[i].second);
	fo(i,pos+1,cnt) R.push(d[i].first,d[i].second);
}

int hd,tl,qd[M];

ll calc(int l,int r) {
	int len=r-l+1;hd=1;tl=0;
	ll ans=-1;
	fo(i,0,len-1) {
		while (hd<=tl&&L.f[L.top][qd[tl]]<=L.f[L.top][i]) tl--;
		qd[++tl]=i;
		ans=max(ans,R.f[R.top][(r-i+Mod)%Mod]+L.f[L.top][qd[hd]]);
	}
	fo(i,len,Mod-1) {
		while (hd<=tl&&L.f[L.top][qd[tl]]<=L.f[L.top][i]) tl--;
		while (hd<=tl&&qd[hd]<=i-len) hd++;
		qd[++tl]=i;
		ans=max(ans,R.f[R.top][(r-i+Mod)%Mod]+L.f[L.top][qd[hd]]);
	}
	fo(i,Mod-len,Mod-1) {
		while (hd<=tl&&qd[hd]<i) hd++;
		ans=max(ans,R.f[R.top][(l-i+Mod)%Mod]+L.f[L.top][qd[hd]]);
	}
	return ans;
}

char opt[5];

int main() {
	read();q=read();Mod=read();
	L.pre();R.pre();
	for(;q;q--) {
		scanf("%s",opt);
		if (opt[0]=='I'&&opt[1]=='F') {
			int w=read(),v=read();
			L.push(w,v);
		}
		if (opt[0]=='I'&&opt[1]=='G') {
			int w=read(),v=read();
			R.push(w,v);
		}
		if (opt[0]=='D'&&opt[1]=='F') {
			if (!L.top) rebuild();
			if (!L.top) R.top--;
			else L.top--;
		}
		if (opt[0]=='D'&&opt[1]=='G') {
			if (!R.top) rebuild();
			if (!R.top) L.top--;
			else R.top--;
		}
		if (opt[0]=='Q') {
			int l=read(),r=read();
			write(calc(l,r));
		}
	}
	return 0;
}

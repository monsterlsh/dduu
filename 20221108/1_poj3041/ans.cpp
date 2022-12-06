#include<iostream>
#include<cstring>
using namespace std;

const int maxn=500+10;
int maps[maxn][maxn];
int a[maxn];
bool vist[maxn];
int n,m,r,c;
bool match(int i){
    for(int j = 1;j<=n;j++)if(maps[i][j] && !vist[j]){
        vist[j] = true;
        if(a[j] == -1 || match(a[j])){
            a[j] = i;
            return true;
        }
    }
    return false;
}
int main(){
    memset(maps,0,sizeof(maps));
    memset(a,-1,sizeof(a));
    
    scanf("%d%d",&n,&m);
    for(int i=0;i<m;i++){
        scanf("%d%d",&r,&c);
        maps[r][c] = 1;
    }
    int ans = 0;
    for(int i=1;i<=n;i++){
        memset(vist,false,sizeof(vist));
        if(match(i)) ans++;
    }
    cout<<ans<<endl;

}
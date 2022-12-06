#include <cstdio>
#include <cstring>
#include <queue>
using namespace std;
const int N = 26;
int n, m, t, d[N][N], g[N][N], in[N]; //d代表传递闭包 g代表原图用于拓扑序判断有边 
char s[4];
int check() {
	//有矛盾的情况 A<A 代表出现一个自环
	for (int i = 0; i < n; i++) if (g[i][i]) return 2;
	
	//有序序列的话 代表所有的2个点之间都能够有一条边 若有2点之间都没边 那么就没有找到
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) { 
			if (!g[i][j] && !g[j][i]) return 0;
		}
	} 
	return 1; //成功找到一条有序序列 
	 
}
void topsort() {
	queue<int> q;
	for (int i = 0; i < n; i++) if (!in[i]) q.push(i);
	printf("Sorted sequence determined after %d relations: ", t);
	while (!q.empty()) {
		int u = q.front();
		q.pop();
		printf("%c", u + 'A');
		for (int v = 0; v < n; v++) {
			if (d[u][v]) {
				in[v]--;
				if (!in[v]) q.push(v);
			}
		}
	}
	printf(".\n");
}
int main() {
	while (scanf("%d%d", &n, &m), n) {
		memset(g, 0, sizeof(g));
		memset(d, 0, sizeof(d));
		memset(in, 0, sizeof(in));
		int st = 0; //0代表没有找到矛盾或有序序列 1 代表找到有序 2找到矛盾 
		for (int i = 1; i <= m; i++) {
			scanf("%s", s); //A < B 建立一条A->B的边
			if (!st) {
				int u = s[0] - 'A'; 
				int v = s[2] - 'A';
				in[v]++; //入度+1
				g[u][v] = d[u][v] = 1;
				for (int i = 0; i < n; i++) {
					if (g[i][u]) g[i][v] = 1;
					if (g[v][i]) g[u][i] = 1; 
					for (int j = 0; j < n; j++) {
						if (g[i][u] && g[v][j]) g[i][j] = 1;
					}
				}
				st = check(); //更新状态
				t = i;  
			}
		} 
		if (!st) printf("Sorted sequence cannot be determined.\n");
		else if (st == 1) topsort();
		else printf("Inconsistency found after %d relations.\n", t); 
	} 
	return 0;
}

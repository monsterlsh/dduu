#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
const int N = 300010; //n次插入和m次查询相关数据量的上界
int n, m;
int a[N];//存储坐标插入的值
int s[N];//存储数组a的前缀和
vector<int> alls;  //存储（所有与插入和查询有关的）坐标
vector<pair<int, int>> add, query; //存储插入和询问操作的数据

int find(int x) { //返回的是输入的坐标的离散化下标
    int l = 0, r = alls.size() - 1;
    while (l < r) {
        int mid = l + r >> 1;
        if (alls[mid] >= x) r = mid;
        else l = mid + 1;
    }
    return r + 1;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++) {
        int x, c;
        scanf("%d%d", &x, &c);
        add.push_back({x, c});
        alls.push_back(x);
    }
    for (int i = 1; i <= m; i++) {
        int l , r;
        scanf("%d%d", &l, &r);
        query.push_back({l, r});
        alls.push_back(l);
        alls.push_back(r);
    }
   //排序，去重
    sort(alls.begin(), alls.end());
    alls.erase(unique(alls.begin(), alls.end()), alls.end());
    //执行前n次插入操作
    for (auto item : add) {
        int x = find(item.first);
        a[x] += item.second;
    }
    //前缀和
    for (int i = 1; i <= alls.size(); i++) s[i] = s[i-1] + a[i];
    for(int i = 1; i <= alls.size(); i++) {printf("%d\t",a[i]);}puts("");
     for(int i = 1; i <= alls.size(); i++)  printf("%d\t",s[i]); puts("");
    //处理后m次询问操作
    for (auto item : query) {
        int l = find(item.first);
        int r = find(item.second);
        printf("l=%d ; r = %d",l,r);
        puts("");
        printf("%d\n", s[r] - s[l-1]);
    }

    return 0;
}

//作者：liangshang
//链接：https://www.acwing.com/solution/content/13511/
//来源：AcWing
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
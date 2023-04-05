#include <iostream>

using namespace std;

const int N = 100010;

int n;
int h[N], e[N], ne[N], head, idx;
void init(){
    head = -1;
    idx = 0;
}
void int_to_head(int x){
       e[idx] = x;//第一步，先将值放进去
       ne[idx] = head;//head作为一个指针指向空节点，现在ne[idx] = head;做这把交椅的人换了
       //先在只是做到了第一步，将元素x的指针指向了head原本指向的
       head = idx;//head现在表示指向第一个元素了，它不在是空指针了。（不指向空气了）
       idx ++;//指针向下移一位，为下一次插入元素做准备。
}
void add(int k, int x){
       e[idx] = x;//先将元素插进去
       ne[idx] = ne[k];//让元素x配套的指针，指向它要占位的元素的下一个位置
       ne[k] = idx;//让原来元素的指针指向自己
       idx ++;//将idx向后挪
}
void remove(int k){
    ne[k] = ne[ne[k]];//让k的指针指向，k下一个人的下一个人，那中间的那位就被挤掉了。
}
int main(){
    cin >> n;
    init();//初始化
    for (int i = 0; i < n; i ++ ) {
        char s;
        cin >> s;
        if (s == 'H') {
            int x;
            cin >> x;
            int_to_head(x);
        }
        if (s == 'D'){
            int k;
            cin >> k;
            if (k == 0) head = ne[head];//删除头节点
            else remove(k - 1);//注意删除第k个输入后面的数，那函数里放的是下标，k要减去1
        }
        if (s == 'I'){
            int k, x;
            cin >> k >> x;
            add(k - 1, x);//同样的，第k个数，和下标不同，所以要减1
        }
    }

    for (int i = head; i != -1; i = ne[i]) cout << e[i] << ' ' ;
    cout << endl;

    return 0;
}

//作者：大海呀大海
//链接：https://www.acwing.com/solution/content/16251/
//来源：AcWing
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
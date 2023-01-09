#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

typedef vector<int> VI;

int b;

VI div(VI &A,int &r){
    r = 0;
    VI C;
    for(int i = A.size()-1; i >= 0; i--){
        r = (r*10+A[i]);
        C.push_back(r/b);
        r %= b;
    }
    reverse(C.begin(),C.end());
    while(C.size() > 1 && C.back() == 0) C.pop_back();

    return C;
}

int main(){
    string a;

    cin >> a >> b;

    VI A,C;
    for(int i = a.size()-1; i >= 0; i--) A.push_back(a[i]-'0');

    int r;
    C = div(A,r);

    for(int i = C.size()-1; i >= 0; i--) cout << C[i];
    cout << endl << r << endl;

    return 0;
}
#include <iostream>
#include <vector>
using namespace std;
int n;
vector<int> arr;
string cases = "Case #";
bool great=false;
void process()
{
    //freopen("input.in","r",stdin);
    scanf("%d", &n);
    arr.resize(3);
    int i=1;
    while (i<=n)
    {

        for (int i = 0; i < 3; i++)
        {
            scanf("%d",&arr[i]);
        }
        int c = arr[0]+arr[1];
        if((arr[0]>0 && arr[1]>0 && c<=0)|| (!(arr[0]<0&&arr[1]<0&&c>=0) && c>arr[2]))  great = true;
        else great = false;
        cout<<cases<<i++<<": "<<(great?"true":"false")<<endl;
    }
}
int main(){
    process();
}
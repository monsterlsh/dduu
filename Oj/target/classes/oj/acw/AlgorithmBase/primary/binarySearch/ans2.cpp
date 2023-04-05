#include<iostream>
using namespace std;
const int N=1e5+5;
int n,m,q[N];
int main()
{
    scanf("%d %d",&n,&m);
    for(int i=0;i<n;i++) scanf("%d",&q[i]);
    while(m--)
    {
        int k;scanf("%d",&k);
        //寻找第一个等于K的坐标 我这边让二分的边界定为 左边为<5 右边>=5 则所求为r
        int l=-1,r=n;
        while(l+1!=r)//当l与r没有相接的时候,求边界
        {
            int mid=l+r>>1;
            //下面找第一个>=5的坐标
            if(q[mid]>=k) r=mid;
            else l=mid;
        }
        //此时得到的r是第一个>=5的坐标
        if(q[r]!=k) printf("-1 -1\n");
        else{
            printf("%d ",r);
                //现在找最后一个<=5的数字 我这边让二分的左边为<=5 右边为>5 则所求为ll
                int ll=-1,rr=n;
                while(ll+1!=rr)
                {

                    int mid=ll+rr>>1;
                    if(q[mid]<=k) ll=mid;
                    else rr=mid;
                }
                if(q[ll]!=k) printf("%d\n",r);
                else printf("%d\n",ll);
            }

    }

}

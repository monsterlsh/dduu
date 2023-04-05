#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n,k;
int arr [100];
int arrk [100];
void printArr(){
    for(int i = 0;i<n-1;i++) cout<<arr[i]<<" ";
    cout<<arr[n-1]<<endl;
}
int main(){
    scanf("%d %d",&n,&k);
    k = k%n;
    for(int i=0;i < n;i++ ) {scanf("%d",arr+i);arrk[i]=arr[i];}
    for(int i=0,pivot = arr[0];i<k;i++,pivot = arrk[i])
        for(int j=i+k;j<n+k;j+=k) {
            swap(pivot,arr[j%n]);
            //printArr();cout<<" pivot="<<(pivot=arr[i])<<endl;
            }
        
    
    printArr();
}

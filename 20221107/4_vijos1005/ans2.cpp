#include<iostream>
#include<string>
using namespace std;

string s;

int a[300][305]={0};
int flag=1;
int kk=0;  
//x[0~(n-m)]=s[n~m] 
int getNum(int x[],int m,int n){
    for(int i=n;i>=m;--i)
    x[n-i]=s[i]-'0';
    }
void print(int x[]){
     int i;
     for(i=300;i>=0;i--)
     if(x[i]!=0) break;
     while(i>=0) cout<<x[i--];
     cout<<endl;
     }
//打印补齐后的第一个数 
void print(int l){
     for(int i=1;i<=l;++i)
     cout<<s[i];
     cout<<endl;
     }
//x=x+t 
void add(int x[],int t){
     x[0]+=t;
     int i=0;
     while(x[i]>=10)
     {
       x[i+1]+=x[i]/10;
       x[i]%=10;
       i++;
                   }
     }
//x=x-t 
void sub(int x[],int t){
     x[0]-=t;
     int i=0;
     while(x[i]<0)
     {
       x[i]+=10;
       x[i-1]-=1;
       i++;
                   }
     }

//前后数位数都足够 
bool check(int i,int j,int m,int n){
     if(s[i]=='0'||s[m]=='0') return false;
     int x[305]={0},y[305]={0};
     getNum(x,i,j);
     getNum(y,m,n);
     add(x,1);
     for(int d=0;d<=300;d++)
     if(x[d]!=y[d]) return false;
     return true;
     }


//后一个数位数不够，只判断后一个数与前一个数对应的位数是否相等 
bool tailCheck(int i,int j,int m,int n){
     if(s[i]=='0'||s[m]=='0') return false;
     int x[305]={0},y[305]={0};
     getNum(x,i,j);
     getNum(y,m,n);
     add(x,1);
     int d1=300,d2=300;
     while(x[d1]==0) d1--;
     while(y[d2]==0) d2--;
     while(d1>=0&&d2>=0)
     {
        if(x[d1]!=y[d2]) return false;        
        d1--;d2--;        
                        }
     return true;
     }


//判断第一个数的位数是否能为l 
bool find(int l){
     int i,j,m,n;
     i=1;j=l;m=j+1;n=j+l;
     if(j==s.size()-1&&s[i]=='0') return false;
     while(true)
     {
       if(j>=s.size()-1) return true;
       if(n>=s.size()-1) {n=s.size()-1;if(!tailCheck(i,j,m,n)) return false;}
       else if(!check(i,j,m,n))  //前一个数和后一个数的位数都为l 
       {
         if(!check(i,j,m,n+1))   //前一个数位数为l,后一个数位数为l+1              
         return false;              
         else {l+=1;n+=1;}  
                            }
       i=m;
       j=n;
       m=j+1;
       n=j+l; 
             
             }
     
     return true;
     }

void Multiply(int x[],int y){
     for(int i=0;i<=300;++i)
     x[i]*=y;
     
     for(int i=0;i<=300;++i)
     if(x[i]>9)
     {
        x[i+1]+=x[i]/10;
        x[i]%=10;
                  }
     }
void add(int x[],int y[]){
     for(int i=0;i<=300;++i)
     x[i]+=y[i];
     int i=0;
     while(x[i]>=10)
     {
       x[i+1]+=x[i]/10;
       x[i]%=10;
       i++;
                   }
     }

bool comp(int x[],int y[]){
     for(int i=300;i>=0;--i)
     if(x[i]<y[i]) return true;
     else if(x[i]>y[i]) return false;
     return false;
     }

void getAns(int finalAns[],int l,int k){
     int x[305]={0},ans[305]={0};
     getNum(x,1,l);
     x[l-1]-=1;
     Multiply(x,l);
     for(int i=0;i<=300;++i)
     ans[i]=a[l-1][i]+x[i];
     ans[0]+=1+k+kk;
     for(int i=0;i<=300;++i)
     if(ans[i]>9)
     {
          ans[i+1]+=ans[i]/10;
          ans[i]%=10;
                    }   
     
     if(flag==1||comp(ans,finalAns))
     for(int i=0;i<=300;++i)
     finalAns[i]=ans[i];
     }
//判断数组是否为1000....0000的形式 
bool Equal1000(int x[]){
     int tot=0;
     for(int i=0;i<=300;++i)
     if(x[i]!=0) tot++;
     if(tot>1) return false;
     return true;
     }

//判断字符串是否为全0 
bool Equal000(string s1){
     for(int i=0;i<s1.size();++i)
     if(s1[i]!='0') return false;
     return true;
     }

     
int main()
{ 
    //a[i]表示所有位数<=i的字符串长度和
    for(int i=1;i<=200;++i)
    {
      a[i][i-1]=9;
      Multiply(a[i],i);
      add(a[i],a[i-1]);
            }
    
    int finalAns[305]={0};
    flag=1;
    
    string s1;
    cin>>s1;
    
    //如果字符串=000...0,则在最前面加上0,令kk=1,最后的答案要减去kk
    if(Equal000(s1))
    {s1="1"+s1;kk=1;}
    
    //l为字符串中第一个数的位数
    //k表示字符串中第一个字符是第一个数的第K+1位，k<l
    for(int l=1;l<=s1.size();++l)
    for(int k=0;k<l;++k)
    {
       s=" "+s1;string s2="";
       if(k==0)
       {
          if(find(l))
             {getAns(finalAns,l,k);flag=0;}
               }
               
       //如果K!=0,则补齐第一个数的前k位 
       if(k!=0)
       {

          int x[305]={0};
          getNum(x,l-k+1,l-k+k);
          
          //1.直接把第l-k+1至l-k+k之间的数补齐第一个数的前k位  
          s2="";
          int i=k-1;
          while(i>=0) s2+=x[i--]+'0';
          s=" "+s2+s1;
          if(find(l))
          {getAns(finalAns,l,k);flag=0;}
          
          //2.如果第l-k+1至l-k+k之间数的形式是10....000,也可以用99....999补齐第一个数的前k位  
          if(Equal1000(x))
          {
             s2="";
             i=k-1;
             while(i>=0) {s2+='9';i--;}
             s=" "+s2+s1;
             if(find(l))
             {getAns(finalAns,l,k);flag=0;}
                          }
          //3.用第l-k+1至l-k+k之间的数减去1,补齐第一个数的前k位  
          sub(x,1);
          i=k-1;
          s2="";
          while(i>=0) s2+=x[i--]+'0';
          s=" "+s2+s1;
          if(find(l))
          {getAns(finalAns,l,k);flag=0;}
               
               } 
            
            }
    
    print(finalAns);        
                  
  //  system("pause");   
    } 

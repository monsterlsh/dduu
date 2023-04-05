#include <iostream>
#include <cstring>
using namespace std;
int win[62503];
int w,l;
int main()
{
	char s;
	for(int i=1;cin>>s&&s!='E';i++)//循环读入，当读到字符E结束
	{
		if(s=='W')win[i]=1;
		else win[i]=2;
	}
	//----------------11分制 ----------------
	for(int i=1;1;i++)
	{
		if(win[i]==1)w++;//胜场+1
		if(win[i]==2)l++;//负场+1
		if(win[i]==0)//读到0则记录结束，输出记录结束前的分数。
		{
			cout<<w<<":"<<l<<endl<<endl;
			break;
		}
		if(w-l>=2||l-w>=2)
			if(w>=11||l>=11)//当双方比分相差大于2且一方分数大等于11输出
			{
				cout<<w<<":"<<l<<endl;
				w=0;//比分清零
				l=0;
			}
	}
	w=0;//清零，为21分制计算做准备
	l=0;
	//----------------21分制 ----------------
	for(int i=1;1;i++)//一切同上，唯一区别就是判定从11变为21
	{
		if(win[i]==1)w++;
		if(win[i]==2)l++;
		if(win[i]==0)
		{
			cout<<w<<":"<<l;
			break;
		}
		if(w-l>=2||l-w>=2)
			if(w>=21||l>=21)//11变为21
			{
				cout<<w<<":"<<l<<endl;
				w=0;
				l=0;
			}
	}
	return 0;//华丽地结束  ㄟ(▔▽▔)ㄏ
}
#include <string>
#include <iostream>
#include <set>
#include <cstdio>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;
struct BigInt
{
static const int Base = 100000000;
static const int Width = 8;
vector <int> s;
BigInt(long long num = 0)
{
*this = num;
}
BigInt(const string &b)
{
*this = b;
}
BigInt operator = (long long num)
{
s.clear();
do
{
s.push_back(num % Base);
num /= Base;
} while (num > 0);
return *this;
}
BigInt operator = (const string& str)
{
s.clear();
int x, len = (str.length() - 1) / Width + 1;
for (int i = 0; i < len; i++)
{
int end = str.length() - i * Width;
int start = max(0, end - Width);
sscanf(str.substr(start, end - start).c_str(), "%d", &x);
s.push_back(x);
}
return *this;
}
BigInt operator + (const BigInt &b) const
{
BigInt res;
res.s.clear();
for (int i = 0, count = 0;; i++)
{
if (count == 0 && i >= s.size() && i >= b.s.size()) break;
int x = count;
if (i < s.size()) x += s[i];
if (i < b.s.size()) x += b.s[i];
res.s.push_back(x % Base);
count = x / Base;
}
return res;
}
BigInt operator * (const int times) const
{
BigInt res;
res.s.clear();
for (int i = 0, carry = 0; ; i++)
{
if (carry == 0 && i >= s.size()) break;
long long x = carry;
if (i < s.size()) x += (long long)times * s[i];
res.s.push_back(x % Base);
carry = x / Base;
}
return res;
}

friend ostream& operator << (ostream &out, const BigInt& x)
{
out << x.s.back();
for (int i = x.s.size() - 2; i >= 0; i--)
{
char buf[20];
sprintf(buf, "%08d", x.s[i]);
for (int j = 0; j < strlen(buf); j++) out << buf[j];
}
return out;
}
};

void find_bit(string num,int blank)
{
int size = num.size();
BigInt ans = 1, count = 9;
for (int i = 1; i < size; i++)
{
ans = ans + (count * i);
count = count * 10;
}

if (num[0] > '0')num[0]--;
if (num[0]=='0' && num !="0") num.erase(num.begin());

ans = ans + BigInt(num) * size;

ans = ans + BigInt(blank);

cout << ans << endl;
}
struct node
{
string num;
int blank;
node(string num, int blank):num(num),blank(blank){
}
bool operator < (const node &b)const
{
if (num.size() < b.num.size()) return true;
if (num.size() > b.num.size()) return false;
if (num < b.num) return true;
if (num > b.num) return false;
if (blank < b.blank) return true;
return false;
}
};

set <node> ansSet;
string& operator ++ (string &a)
{
int size = a.size();
int carry = 1;
for (int i = size - 1; i>=0; i--)
{
int x = carry + a[i] - '0';
a[i] = x % 10 + '0';
carry = x/10;

}
if (carry > 0)
{
a = "1";
for (int i=0; i < size; i++) a+="0";
}
return a;
}

string& operator -- (string &a)
{
int size = a.size();
int carry = -1;
for (int i = size - 1; i >= 0; i--)
{
int x = carry + a[i] - '0';
carry = 0;
if (x < 0)
{
carry = -1;
x += 10;
}
a[i] = x + '0';
}
if (a[0] == '0' && a.size()!=1) a.erase(0,1);
return a;
}

bool check(string &a, string &b,int pos = 0, int blank = 0)
{
for (int i = 0, j = pos + blank;i < a.size() && j < b.size(); i++,j++)
{
if (a[i] != b[j]) return false;
}
return true;
}

bool check_through(string a,string &b, int pos)
{
for (;pos < b.size(); pos += a.size())
{
++a;
if (!check(a,b,pos)) return false;
}
return true;
}

bool all(string &a,char c)
{
for (int i = 0; i < a.size(); i++)
if (a[i]!=c) return false;
return true;
}
int main()
{
string s;
cin >> s;
if (all(s,'0'))
{
s = "1" +s;
find_bit(s,1);
}
else for (int len = 1; len <= s.size(); len++)
{
ansSet.clear();
for (int blank = 0; blank < len; blank++)
{
string a,num="";
a.assign(s,0,len-blank);
int p = len - blank;
if (all(a,'9'))
{
string zero;
zero.assign(len - blank, '0');
string temp = "1";//1000000000
temp.append(len, '0');
if (check(temp,s,p))
{
num.assign(len, '9');
}
else if (s[p]!='0'&&check(zero,s,p,blank))
{
num.assign(s,p,blank);
--num;
num += a;
}
}
else
{
string temp = a;
++temp;
if (s[p]!='0'&&check(temp,s,p,blank))
{
num.assign(s,p,blank);
num += a;
}
}
/* test
printf("len = %d, blank = %d, p = %d, num=",len,blank,p);
cout << num << endl;
// test*/

if (num != "" && num[0]!='0'&& check_through(num,s,p))
ansSet.insert(node(num,blank));
}
if (!ansSet.empty())
{
// cout << ansSet.begin()->num << endl;
string num = ansSet.begin()->num;
int blank = ansSet.begin()->blank;
if (all(num,'0')){
num = "1" +num;
blank = 1;
}
find_bit(num,blank);

break;
}
}
}
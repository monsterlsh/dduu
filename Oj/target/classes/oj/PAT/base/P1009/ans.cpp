#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
void printArray(const vector<string> &arr)
{
    int i = arr.size()-1;
    for (; i >0; i--)
        cout << arr[i] << " ";
    if (i >= 0)
        cout << arr[i] << endl;
}

vector<string> split(const string& str, const string& delim) {
	vector<string> res;
	if("" == str) return res;
	//先将要切割的字符串从string类型转换为char*类型
	char * strs = new char[str.length() + 1] ; //不要忘了
	strcpy(strs, str.c_str()); 
 
	char * d = new char[delim.length() + 1];
	strcpy(d, delim.c_str());
 
	char *p = strtok(strs, d);
	while(p) {
		string s = p; //分割得到的字符串转换为string类型
		res.push_back(s); //存入结果数组
		p = strtok(NULL, d);
	}
 
	return res;
}
void split(const std::string& str, 
           std::vector<std::string>& tokens, 
           const std::string delim) {
    tokens.clear();
    auto start = str.find_first_not_of(delim, 0);       // 分割到的字符串的第一个字符
    auto position = str.find_first_of(delim, start);    // 分隔符的位置
    while (position != std::string::npos || start != std::string::npos) {
        // [start, position) 为分割下来的字符串
        //cout<<" start: "<<start<<" position: "<<position<<endl;
        if(position != std::string::npos)
        tokens.emplace_back(std::move(str.substr(start, position - start)));
        else 
        tokens.emplace_back(std::move(str.substr(start)));
        start = str.find_first_not_of(delim, position);
        position = str.find_first_of(delim, start);
    }
}
string reverseSentence(){
    string str;
    getline(cin,str);
    //string str = "Hello World Here I Come";
    vector<string>res;
    split(str,res," ");
    printArray(res);
    return str;
}

int main(){
    reverseSentence();
}
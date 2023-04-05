##include<iostream>
#include<string>
class Solution {
public:
	string reverseLeftWords(string s, int n) {
		s.reserve(s.size() + n);//修改预留长度，避免push_back重复开辟空间
		for (int i = 0; i < n; i++) {
			s.push_back(s[i]);//添加前缀到后面
		}
		return  s.data() + n;//获取指针，并往后移动
	}
};

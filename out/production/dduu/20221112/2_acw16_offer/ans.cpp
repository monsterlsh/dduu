#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
    string replaceSpaces(string &str) {
        string arr = "";
        for(auto & c : str){
            if(c==' '){
                arr.push_back('%');
                arr.push_back('2');
                arr.push_back('0');
            }else arr.push_back(c);
        }
        return arr;
    }
};
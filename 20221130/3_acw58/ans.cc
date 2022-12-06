#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
class Solution {
public:
    static bool myCmp(int &a, int &b) {
        if (to_string(a) + to_string(b) < to_string(b) + to_string(a))
        return true;
        else return false;
    }
    string printMinNumber(vector<int>& nums) {
        string str;
        if(!nums.size()) return str;
        sort(nums.begin(), nums.end(), myCmp);
        for(int i = 0 ; i < nums.size(); i ++ ) {
            str += to_string(nums[i]);
        }

    return str;    
    }

};

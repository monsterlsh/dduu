#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> permutation(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<bool>vi(nums.size());
        vector<int>tmp;
        sort(nums.begin(),nums.end());
        bfs(nums,tmp,ans,vi,0,nums.size());
        return ans;
    }
    void bfs(vector<int>& nums,vector<int>&tmp,vector<vector<int>>& ans,vector<bool>&vi,int i,int n){
        if(i==n) {ans.push_back(tmp); return;}
        for(int j=0;j<n;j++){
            if(vi[j] || (j > 0 && !vi[j-1] && nums[j-1]==nums[j])) continue;
            vi[j] = true;
            tmp.push_back(nums[j]);
            bfs(nums,tmp,ans,vi,i+1,n);
            tmp.pop_back();
            vi[j] = false;
        }
    }
};
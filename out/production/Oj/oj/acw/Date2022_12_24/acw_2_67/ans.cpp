#include<iostream>
#include<vector>
using namespace std;

class Solution{
public:
    int getNumberOfK(vector<int>& nums , int k) {
        int lefindex = bianrySearch(nums,true,k);
        int rightindex = bianrySearch(nums,false,k) - 1;
        if(lefindex <= rightindex && rightindex < nums.size() && nums[lefindex]== k && nums[rightindex] == k)
            return rightindex - lefindex +1;
        return 0;
    }
    int bianrySearch(vector<int> & nums, bool lower,int target){
        int left = 0, right = nums.size()-1,ans = nums.size();
        while (left <= right)
        {
            /* code */
            int mid = left + (right - left) >> 1;
            if(nums[mid] > target || (lower && nums[mid]>= target)){
                right = mid-1;
                ans = mid;
            }else left = mid+1;
        }
        return ans;
        
    }
};
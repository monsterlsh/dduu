//55. 连续子数组的最大和

class Solution {
public:
    int dp[100010];
    int maxSubArray(vector<int>& nums) {
        nums.insert(nums.begin(),0);
        int ans = -9999999;
        for(int i = 1;i<nums.size();i++){
            dp[i] = max(dp[i-1]+nums[i],nums[i]);
            ans = max(ans,dp[i]);
        }

        return ans;
    }
};

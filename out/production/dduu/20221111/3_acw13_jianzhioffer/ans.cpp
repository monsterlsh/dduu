#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    int duplicateInArray(vector<int>& nums) {
        int n = nums.size();
        for (auto x : nums)
            if (x < 0 || x >= n)
                return -1;
        for (int i = 0; i < n; i ++ ) {
            while (nums[nums[i]] != nums[i]) swap(nums[i], nums[nums[i]]);
            if (nums[i] != i) return nums[i];
        }
        return -1;
    }

    int duplicateInArray_(vector<int>& nums) {
        int l = 1, r = nums.size() - 1;
        while (l < r) {
            int mid = l + r >> 1; // 划分的区间：[l, mid], [mid + 1, r]
            int s = 0;
            for (auto x : nums) s += x >= l && x <= mid;
            if (s > mid - l + 1) r = mid;
            else l = mid + 1;
        }
        return r;
           
    }
    int duplicateInArray_3(vector<int>& nums) {
        int f = 0, s = 0;
        while (f == 0 || f != s) {
            f = nums[nums[f]];
            s = nums[s];
        }

        f = 0;
        while (f != s) {
            f = nums[f];
            s = nums[s];
        }
        return s;
    }
    int findRepeatNumber(vector<int>& nums) {
        int x = 0, y = 0;
        for (; !x || (x ^ y); x = nums[nums[x]], y = nums[y]);
        for (x = 0; x ^ y; x = nums[x], y = nums[y]);
        return x;
    
    }

    int findRepeatNumber(vector<int>& nums) {
        int repeat,tmp;
        for(int i = 0;i<nums.size();i++){
            if(nums[i] == i ) continue;
            repeat = nums[i];
            if(nums[repeat]==repeat)return repeat;
            tmp = nums[repeat];
            nums[repeat] = repeat;
            nums[i] = tmp;
            i--;
        }
        return -1;
    }
};
int main(){
    vector<int> arr = {2, 3, 5, 4, 3, 2, 6, 7};
    Solution s;
    cout<<s.duplicateInArray_(arr);
}


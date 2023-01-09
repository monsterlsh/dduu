package oj.acw.offer.Date2022_12_24.acw_3_68;

class Solution {

    public int getMissingNumber(int[] nums) {
        int n = nums.length + 1;
        int total = n * (n - 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < n - 1; i++) {
            arrSum += nums[i];
        }
        return total - arrSum;
    }
}
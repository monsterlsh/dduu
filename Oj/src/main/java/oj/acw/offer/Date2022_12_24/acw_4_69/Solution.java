package oj.acw.offer.Date2022_12_24.acw_4_69;

public class Solution {
    public int getNumberSameAsIndex(int[] nums) {
        int left = 0, right = nums.length - 1,mid=0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == mid) return mid;
            if(nums[mid] < mid) left = mid+1;
            else right = mid - 1;
        }
        return  -1;
    }

}

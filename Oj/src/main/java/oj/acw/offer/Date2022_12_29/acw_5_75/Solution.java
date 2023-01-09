package oj.acw.offer.Date2022_12_29.acw_5_75;

import java.util.Arrays;

public class Solution {
    public int[] findNumbersWithSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left =0,right = find(nums,target,0,nums.length-1),tmp;
        while (left<right){
            if( (tmp = nums[left] + nums[right])== target) return  new int[]{nums[left],nums[right]};
            else if(tmp > target) --right;
            else ++left;
        }
        return new int[]{-1,-1};
    }
    //找到第一个比target大的值
    public int find(int [] nums,int target,int left,int right){

        while(left < right){
            int mid = left + (right - left) / 2;
            //if(nums[mid] == target) return mid-1;
            if(nums[mid] >= target) right = mid-1;
            else left = mid+1;
        }
        return right;
    }
}

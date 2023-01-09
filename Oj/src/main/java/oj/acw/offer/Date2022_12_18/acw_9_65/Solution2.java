package oj.acw.offer.Date2022_12_18.acw_9_65;

public class Solution2 {

    public int reversePairs(int[] nums){
        int len = nums.length;
        if(len < 2) return 0;
        int copy[] = new int[len];
        System.arraycopy(nums,0,copy,0,len);
        int temp [] = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }
    private int reversePairs(int [] nums,int left,int right,int [] temp){
        if(left == right) return 0;
        int mid = left + (right - left) /2;
        int leftPairs = reversePairs(nums,left,mid,temp);
        int rightPairs = reversePairs(nums,mid+1,right,temp);
        if(nums[mid] <= nums[mid+1]) return leftPairs+rightPairs;

        int crossPairs = mergeAndCount(nums,left,mid,right,temp);
        return leftPairs+rightPairs +crossPairs;

    }
    private int mergeAndCount(int [] nums,int left,int mid,int right,int [] temp){
        System.arraycopy(nums,left,temp,left,right-left+1);
        int i = left, j = mid+1;
        int res = 0;
        for (int k=left;k<=right;k++){
            if(i == mid+1){
                nums[k] = temp[j];
                j++;
            }
            else if (j == right+1){
                nums[k] = temp[i];
                i++;
            }
            else if(temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            }
            else {
                nums[k] = temp[j];
                j++;
                res += (mid - i +1);
            }
        }
        return res;
    }
}
 class Main2{
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int [] nums = {7,5,6,4};
        System.out.println(solution.reversePairs(nums));
    }
}

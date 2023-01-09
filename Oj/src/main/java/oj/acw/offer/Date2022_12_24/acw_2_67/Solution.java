package oj.acw.offer.Date2022_12_24.acw_2_67;

public class Solution {


    /**
     * @param nums
     * @param k
     * @return
     * 统计一个数字在排序数组中出现的次数。
     *
     * 例如输入排序数组 [1,2,3,3,3,3,4,5] 和数字 3，由于 3 在这个数组中出现了 4 次，因此输出 4。
     */
    public int getNumberOfK(int[] nums, int k) {

        return search(nums,k);
    }

    public int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

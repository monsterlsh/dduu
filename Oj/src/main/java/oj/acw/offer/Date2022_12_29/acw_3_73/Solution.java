package oj.acw.offer.Date2022_12_29.acw_3_73;

import java.util.HashMap;

public class Solution {

    public int[] findNumsAppearOnce(int[] nums) {
        HashMap<Integer, Integer> ones = new HashMap<>();
        int [] res = new int[2];
        for(int i=0; i < nums.length; i++){
            if(ones.containsKey(nums[i])) ones.put(nums[i],ones.get(nums[i])+1);
            else ones.put(nums[i],1);
        }
        var ref= new Object() {
            int i = 0;
        };
        ones.forEach((k,v)->{if(v==1)res[ref.i++] = k;});
        return res;
    }

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

}

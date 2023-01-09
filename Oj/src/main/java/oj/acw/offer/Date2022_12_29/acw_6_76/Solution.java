package oj.acw.offer.Date2022_12_29.acw_6_76;


import java.util.*;

public class Solution {
    public void adds(List<List<Integer>> res,int sum,int n ){
        if(sum % n != 0) return;
        List<Integer> tmp = new ArrayList<>();
        int startValue = sum / n;
        for (int k = startValue; k < startValue+n; k++) {
            tmp.add( k);
        }
        res.add(tmp);
    }
    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> res = new ArrayList<>();

        //因为至少是两个数，所以target先减1
        sum--;
        for (int n = 2; sum > 0; n++) {
            //找到了一组满足条件的序列
            adds(res,sum,n);
            sum -= n;
        }
        Collections.reverse(res);
        return res;
    }


    //双指针
    public int[][] findContinuousSequence2(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }


    public void adds2(List<int[]> res,int target,int n){
        if(target % n != 0) return;
        int[] arr = new int[n];
        //找出首项的值
        int startValue = target / n;
        for (int k = 0; k < n; k++) {
            arr[k] = startValue + k;
        }
        res.add(arr);
    }
    //数学优化1
    public int[][] findContinuousSequence3(int target) {
        List<int[]> res = new ArrayList<>();
        int n = 2;
        //死循环
        while (true) {
            int total = target - n * (n - 1) / 2;
            //当分子小于等于0的时候，退出循环
            if (total <= 0)
                break;
            //如果首项是正整数，满足条件
            adds2(res,total,n);
            //继续找
            n++;
        }
        //反转，比如当target等于9的时候，结果是
        //[[4,5],[2,3,4]]，但题中要求的是不同
        // 序列按照首个数字从小到大排列，所以这里反转一下
        Collections.reverse(res);
        //把list转化为数组
        return res.toArray(new int[res.size()][]);
    }

    //数学优化2
    public int[][] findContinuousSequence4(int target) {
        List<int[]> res = new ArrayList<>();
        //因为至少是两个数，所以target先减1
        target--;
        for (int n = 2; target > 0; n++) {
            //找到了一组满足条件的序列
            adds2(res,target,n);
            target -= n;
        }
        Collections.reverse(res);
        //把list转化为数组
        return res.toArray(new int[res.size()][]);
    }



}

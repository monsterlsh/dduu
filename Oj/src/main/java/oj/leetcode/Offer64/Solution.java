package oj.leetcode.Offer64;

public class Solution {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    //俄罗斯农民乘法
    public int sumNums2(int n) {
        int ans = 0, A = n, B = n + 1;
        boolean flag;
        for (int i=0;i<14;i++){
            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;
        }

        return ans >> 1;
    }
    //通常用在大数相乘取模的情况，可以防止大数相乘溢出。
    public int quickMulti(int A, int B) {
        int ans = 0;
        for ( ; B>0; B >>= 1) {
            if ((B & 1) !=0) {
                ans += A;
            }
            A <<= 1;
        }
        return ans;
    }


}

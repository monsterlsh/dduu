package oj.leetcode.Offer65;

public class Solution {
    public int add(int a, int b) {
        int c = 0,res=0,mod,tmp=1;
        while (a != 0 || b!=0){
            mod = (a&1)+(b&1)+c;
            res += tmp*(mod%2);
            tmp <<=1;
            a>>>=1;
            b>>>=1;
            c = mod/2;
        }
        return res;
    }

    public int add2(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}

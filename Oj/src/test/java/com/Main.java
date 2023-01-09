package com;

import oj.acw.offer.Date2022_12_29.acw_8_78.Solution;
import org.junit.Test;


public class Main {
    @Test
    public void test(){
        String[] s = "a  b".trim().split(" ");
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }
    @Test
    public void test_2022_12_29_8(){
        Solution s = new Solution();
        String str = "abcdefg";
        String s1 = s.leftRotateString(str, 2);

    }
    @Test
    public void mutlti(){

        long a = 3101886402615264L;
        long ans = 68162760049436924L;
        long c = 133223633696258584L;
        System.out.println((ans%c)*(a%c) %c);
    }
}

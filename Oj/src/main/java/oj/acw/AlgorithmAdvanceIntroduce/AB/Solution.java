package oj.acw.AlgorithmAdvanceIntroduce.AB;

import java.util.Scanner;

public class Solution {
    public long solution(long a,long b,long c){
        long ans = 1;
        while (b!=0){
            if((b&1) == 1){
                ans = (ans*a) % c;
            }
            a=(a*a)%c;
            b >>= 1;
        }
        return ans%c;
    }
}
class Main{
    public static void main(String[] args) {
        long a,b,p;
        try (Scanner scanner = new Scanner(System.in)) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            p = scanner.nextInt();
        }
        long res = new Solution().solution(a, b, p);
        System.out.println(res);
    }
}

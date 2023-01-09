package oj.acw.AlgorithmBase.primary.sumOfPefixes;

import java.util.Scanner;

public class Main {
    int n,m;
    Scanner scaner;
    int [] nums;
    public Main(){
        scaner = new Scanner(System.in);
        n = scaner.nextInt();
        m = scaner.nextInt();
        nums = new int[n];
        nums[0] = scaner.nextInt();
        for (int i = 1; i < n; i++) {
            nums[i] = scaner.nextInt()+nums[i-1];
        }

    }
    public void solu(){
        while (m-- !=0){
            int l = scaner.nextInt();
            int r = scaner.nextInt();
            if(l<=1) System.out.println(nums[r-1]);
            else System.out.println(nums[r-1]-nums[l-2]);
        }
    }

    public static void main(String[] args) {
        new Main().solu();
    }
}

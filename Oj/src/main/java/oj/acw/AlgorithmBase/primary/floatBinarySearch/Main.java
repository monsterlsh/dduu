package oj.acw.AlgorithmBase.primary.floatBinarySearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();

        double l = 0, r = Math.abs(n);  // 考虑 n为负数的情况

        while (r - l > 1e-8) {  // // 精度比所求精度高 2位
            double mid = (l + r) / 2;
            if (mid * mid * mid >= Math.abs(n))   // 不需要考虑边界问题
                r = mid;
            else
                l = mid;
        }
        if (n >= 0)
            //System.out.println(String.format("%.6f", l)); // 保留 6位小数
            System.out.printf("%.6f\n",l);
        else
            System.out.println("-" + String.format("%.6f", l));
    }

}

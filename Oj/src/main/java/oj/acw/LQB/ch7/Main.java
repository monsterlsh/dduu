package oj.acw.LQB.ch7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main  {
    int n;
    int [] arr = new int [100001];
    long sum = 0;
    void read()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        String [] split = br.readLine().split(" ");
        int[] array = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        int mid = array[array.length>>1];
        for(int e : array) sum += (long)(Math.abs(mid-e));
        System.out.println(sum);
    }
    public static void main(String [] args) throws IOException {
        new Main().read();
    }

}

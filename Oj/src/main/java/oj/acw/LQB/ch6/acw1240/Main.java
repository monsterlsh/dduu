package oj.acw.LQB.ch6.acw1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    int n;
    static final int N = 100010;
    int [] arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        n = Integer.parseInt(br.readLine().trim());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int ans_level=1,level = 1,last_level_end=0,level_end=1;
        long ans_sum = arr[0],sum = 0;
        int root = 0,left=0,right=0;
        while (!queue.isEmpty()){

            sum = 0;

            while (!queue.isEmpty() ){
                root = queue.poll();
                left = root << 1 | 1;
                right = left+1;
                if(left < arr.length) {
                    queue.offer(left);
                    level_end = left;
                }
                if(right < arr.length){
                    queue.offer(right);
                    level_end = right;
                }
                sum  += arr[root];
                if( root >= last_level_end) break;
//                System.out.print(arr[root]+" ");
            }
            last_level_end = level_end;
//            System.out.println(String.format("\nlevel=%d, sums=%d",level,sum));
            if(sum > ans_sum) {
                ans_sum = sum;
                ans_level = level;
            }
            level++;
        }
        System.out.println(ans_level);
    }

    public static void main(String[] args) throws IOException {
        Main a = new Main();
        a.solution();;
    }
}

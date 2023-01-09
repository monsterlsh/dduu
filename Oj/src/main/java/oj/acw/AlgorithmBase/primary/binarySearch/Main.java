package oj.acw.AlgorithmBase.primary.binarySearch;

import java.util.Scanner;

public class Main {
    int n,k;
    int [] nums;
    public void read(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scanner.nextInt();
        int tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp = scanner.nextInt();
            find_x(tmp);
        }
    }
    public void find_x(int x){

        int l = binarySearch(0,n-1,x,true);
        if( nums[l] != x) {
            System.out.println("-1 -1");
            return;
        }
        int r = binarySearch(0,n-1,x,false);
        if(r<n && nums[r] !=x) --r;
        System.out.printf("%d %d\n",l,r);
    }
    public int binarySearch(int left,int right,int target,boolean flag){
        int mid = 0 ;
        while (left < right){
            mid = left+right >> 1;
            if(nums[mid] > target || (flag && nums[mid] >= target )) right = mid;
            else left = mid+1;
        }
        return flag ? right : left ;

    }

    public static void main(String[] args) {
        new Main().read();
    }

}

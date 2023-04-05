package oj.luogu.basically.P1062;

import java.util.Scanner;

public class Main {
    int k,n;
    int [] arr = new int[1001];
    public void result(){
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        n = scanner.nextInt();
        arr[0]=1;arr[1]=2;
        int i=2,sums=arr[0]+arr[1],tmp=k;
        while (sums<=n){
            arr[i] = arr[i-1]+arr[i-2]+1;
            sums += arr[i];
            tmp*=k;
            i++;
        }
        sums -= arr[i--];
        n -= sums-arr[i];
        tmp /= k;
        int [] dp = new int [1000];
        if(n==1) System.out.println(tmp);
        else{
            int idx = 0;
            dp[idx] = 1;
            n--;
            for(int j=1;j<=i && n!=0;j++){
                dp[++idx] = k;
                k *=k;
                int tmpidx = idx;
                n--;
                for(int m=0;m<=tmpidx && n!=0;m++){
                    dp[++idx] = +dp[m];
                    n--;
                }
            }

            System.out.println(dp[idx]+tmp);
        }

    }

    public static void main(String[] args) {
        new Main().result();
    }
}

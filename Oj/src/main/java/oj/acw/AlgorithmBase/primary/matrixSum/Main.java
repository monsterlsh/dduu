package oj.acw.AlgorithmBase.primary.matrixSum;

import java.util.Scanner;

public class Main {

    int n,m,q;
    int [][] matrix;
    int [][] sum;
    private void read(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        matrix = new int[n+1][m+1];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++) {
                matrix[i][j] = scanner.nextInt();
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
            }
        }
    }
}

package 十月.day2024_10_10;

import java.util.Arrays;

public class leetcode62不同路径 {
    public int uniquePaths1(int m, int n) {
        return nhelper(m,n,1,1);
    }
    public static int nhelper(int m,int n,int i,int j){
        if(i==m&&j==n){
            return 1;
        }
        if(i==m){
            return nhelper(m,n,i,j+1);
        }
        if(j==n){
            return nhelper(m,n,i+1,j);
        }
        return nhelper(m,n,i+1,j)+nhelper(m,n,i,j+1);
    }
    public int uniquePaths2(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        //列长是m,行长是n
        //先初始化列
        for(int i=0;i<=m;i++){
            dp[i][n]=1;
        }
        //再初始化行
        for(int i=0;i<=n;i++){
            dp[m][i]=1;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[1][1];
    }
    public int uniquePaths(int m, int n) {
        int[] dp=new int[m+1];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=m-1;j>=1;j--){
                dp[j]+=dp[j+1];
            }
        }
        return dp[1];
    }
}

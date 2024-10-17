package 十月.day2024_10_14;

import java.util.Arrays;

public class leetcode1884鸡蛋掉落问题 {
    public static int twoEggDrop1(int n) {
        if(n==1){
            return 1;
        }
        int res=Integer.MAX_VALUE;
        for(int i=2;i<=n;i++){
            res=Math.min(res,Math.max(i,twoEggDrop1(n-i)+1));
        }
        return res;
    }
    public static int twoEggDrop2(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=2;j<=i;j++){
                dp[i]=Math.min(dp[i],Math.max(j,dp[i-j]+1));
            }
        }
        return dp[n];
    }
    public static int twoEggDrop(int n) {
        return (int)Math.ceil((Math.sqrt(8*n+1)-1)/2);
    }
    public static void main(String[] args) {
        int n=100;
        int ans=twoEggDrop(n);
        System.out.println(ans);
    }
}

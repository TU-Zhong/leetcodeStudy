package 九月.day2024_9_4;

public class leetcode70爬楼梯 {
    public static int climbStairs(int n) {
        return climbStairshelper(n,0);
    }
    public static int climbStairshelper(int n,int index){
        if(index==n){
            return 1;
        }
        if(index>n){
            return 0;
        }
        int ans1=climbStairshelper(n,index+1);
        int ans2=climbStairshelper(n,index+2);
        return ans1+ans2;
    }
    public static int climbStairshelper2(int n){
        int[] dp=new int[n+1];
        dp[n-1]=1;
        dp[n]=1;
        for(int i=n-2;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int n=2;
        int ans=climbStairs(n);
        int ans2=climbStairshelper2(n);
        System.out.println(ans);
        System.out.println(ans2);
    }
}

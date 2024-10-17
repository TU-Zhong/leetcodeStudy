package 九月.day2024_9_12;

public class leetcode2787 {
    public static int numberOfWays(int n, int x) {
        return (int)(numberOfWayshelper(n,x,1)%1000000007);
    }
    public static long numberOfWayshelper(int n,int x,int num){
        if(Math.pow(num,x)>n){
            return 0;
        }
        if(Math.pow(num,x)==n){
            return 1;
        }
        //不选择当前的数
        long ans1=numberOfWayshelper(n,x,num+1);
        //选择当前的数
        long ans2=numberOfWayshelper(n-(int)Math.pow(num,x),x,num+1);
        return ans1+ans2;
    }
    public static int numberOfWayshelper(int n,int x){
        int max=(int)Math.pow(n,1.0/x)+1;
//        double max2=Math.pow(n,1.0/x);
        long[][] dp=new long[n+1][max+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=1;
        }
        if(Math.pow(max,x)==n){
            dp[n][max]=1;
        }
        for(int i=0;i<=n;i++){
            for(int j=max-1;j>=0;j--){
                if(i>=(int)Math.pow(j,x)){
                    dp[i][j]=dp[i][j+1]+dp[i-(int)Math.pow(j,x)][j+1];
                }else{
                    dp[i][j]=dp[i][j+1];
                }
            }
        }
        return (int)(dp[n][1]%1000000007);
    }
    public static void main(String[] args) {
        int n=10;
        int x=2;
        int ans=numberOfWays(n,x);
        int ans2=numberOfWayshelper(n,x);
        System.out.println(ans2);
        System.out.println(ans);
    }
}

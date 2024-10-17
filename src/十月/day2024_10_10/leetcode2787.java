package 十月.day2024_10_10;

public class leetcode2787 {
    public static int numberOfWays1(int target,int x){
        int a=(int)Math.round(Math.pow(target,1.0/x));
        return nhelper(a,x,1,target);
    }
    public static int nhelper(int limit,int x,int i,int target){
        if(target==0){
            return 1;
        }
        if(i==limit+1 || target<0){
            return 0;
        }
        int a=(int)Math.pow(i,x);
        int ans1=nhelper(limit,x,i+1,target-a);
        int ans2=nhelper(limit,x,i+1,target);
        return ans1+ans2;
    }
    public static int numberOfWays(int target,int x){
        int a=(int)Math.round(Math.pow(target,1.0/x));
        long[][] dp=new long[target+1][a+2];
        for(int i=1;i<=a+1;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<=target;i++){
            for(int j=a;j>=1;j--){
                int res=(int)Math.pow(j,x);
                if(i<res){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-res][j+1]+dp[i][j+1];
                }
            }
        }
        return (int)(dp[target][1]%1000000007);
    }
    public static void main(String[] args) {
        int target=4;
        int x=1;
        System.out.println(numberOfWays(target,x));
    }
}

package 九月.day2024_9_4;

public class leetcode2466统计构造好字符串的方法数 {
    public static int countGoodStrings(int low,int high,int zero,int one){
        return countGoodStringshelper(low,high,zero,one,0);
    }
    public static int countGoodStringshelper(int low,int high,int zero,int one,int index){
        if(index>high){
            return 0;
        }
        if(index>=low){
            int ans1=countGoodStringshelper(low,high,zero,one,index+one);
            int ans2=countGoodStringshelper(low,high,zero,one,index+zero);
            return 1+ans1+ans2;
        }
        int ans1=countGoodStringshelper(low,high,zero,one,index+one);
        int ans2=countGoodStringshelper(low,high,zero,one,index+zero);
        return ans1+ans2;
    }
    static int MOD=1000000007;
    public static int countGoodStringshelper(int low,int high,int zero,int one){
        int[] dp=new int[high+1];
        for(int i=high;i>=0;i--){
            if(i>=low ){
                if(i+one<=high){
                    dp[i]=dp[i+one]%MOD+dp[i]%MOD;
                }
                if(i+zero<=high){
                    dp[i]=dp[i]%MOD+dp[i+zero]%MOD;
                }
                dp[i]+=1;
            }else{
                if(i+one<=high){
                    dp[i]=dp[i]%MOD+dp[i+one]%MOD;
                }
                if(i+zero<=high){
                    dp[i]=dp[i]%MOD+dp[i+zero]%MOD;
                }
            }
        }
        return dp[0]%MOD;
    }
    public static void main(String[] args) {
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(countGoodStringshelper(low,high,zero,one));
    }
}

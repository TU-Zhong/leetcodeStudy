package 九月.day2024_9_12;

import java.util.Arrays;

public class leetcode3180注意数据范围为什么memo可以直接用4000想清楚 {
    public static int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int[][] memo=new int[rewardValues.length][4000];
        return maxTotalRewardhelper(rewardValues,0,0,memo);
    }
    public static int maxTotalRewardhelper(int[] s,int index,int total,int[][] memo){
        if(index>=s.length){
            return total;
        }
        int ans=0;
        if(memo[index][total]!=0){
            return memo[index][total];
        }
        if(s[index]>total){
            //选择当前的数加上
            int ans1=maxTotalRewardhelper(s,index+1,total+s[index],memo);
            //不选择当前的数,那么就不可能再选择它了，因为后面的数都比它大
            int ans2=maxTotalRewardhelper(s,index+1,total,memo);
            ans=Math.max(ans1,ans2);
        }else{
            ans=maxTotalRewardhelper(s,index+1,total,memo);
        }
        memo[index][total]=ans;
        return ans;
    }
    public static int maxTotalRewardhelper(int[] s){
        int[][] dp=new int[s.length+1][4000];
        for(int i=0;i<4000;i++){
            dp[s.length][i]=i;
        }
        int max=0;
        //上面是index
        for(int i=s.length-1;i>=0;i--){
            //下面是total
            for(int j=dp[0].length-1;j>=0;j--){
                if(s[i]>j){
                    dp[i][j]=Math.max(dp[i+1][j+s[i]],dp[i+1][j]);
                }else{
                    dp[i][j]=dp[i+1][j];
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums={1,6,4,3,2};
        int ans=maxTotalReward(nums);
        int ans1=maxTotalRewardhelper(nums);
        System.out.println(ans1);
        System.out.println(ans);
    }
}

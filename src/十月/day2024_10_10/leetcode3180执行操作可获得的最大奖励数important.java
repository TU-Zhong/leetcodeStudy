package 十月.day2024_10_10;

import java.util.Arrays;

public class leetcode3180执行操作可获得的最大奖励数important {
    public static int maxTotalReward1(int[] rewardValues) {
        Arrays.sort(rewardValues);
        return nhelper(rewardValues,0,0);
    }

    public static int nhelper(int[] nums,int index,int res){
        if(index==nums.length){
            return 0;
        }
        int ans1=0;
        int ans2=0;
        if(nums[index]<=res){
            return nhelper(nums,index+1,res);
        }
        ans1=nhelper(nums,index+1,res);
        ans2=nums[index]+nhelper(nums,index+1,res+nums[index]);
        return Math.max(ans1,ans2);
    }
    //完全按照递归函数来进行改写，依赖于左边和下边，target的边界经过数学证明（等比数列求和）可以得知就是数组中最大元素的两倍（不要深究）
    public static int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int target=rewardValues[rewardValues.length-1]*2;
        int[][] dp=new int[target+1][rewardValues.length+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=rewardValues.length-1;j>=0;j--){
                if(rewardValues[j]<=i){
                    dp[i][j]=dp[i][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i][j+1],rewardValues[j]+dp[i+rewardValues[j]][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}

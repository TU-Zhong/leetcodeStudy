package 十月.day2024_10_8.最长子序列问题.leetcode300;

import java.util.Arrays;

public class leetcode300_2 {
    public static int lengthOfLIS(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,lengthOfLIShelper(nums,i));
        }
        return max;
    }
    public static int lengthOfLIShelper(int[] nums,int index){
        if(index==nums.length){
            return 0;
        }
        int max=1;
        for(int i=index+1;i<nums.length;i++){
            if(nums[i]>nums[index]){
                max=Math.max(1+lengthOfLIShelper(nums,i),max);
            }
        }
        return max;
    }
    public static int length(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}

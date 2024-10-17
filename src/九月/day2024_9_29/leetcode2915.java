package 九月.day2024_9_29;

import java.util.Arrays;
import java.util.List;

public class leetcode2915 {
    public static int lengthOfLongestSubsequence(List<Integer> nums, int target){
        int[] nums1=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            nums1[i]=nums.get(i);
        }
        int[][] memo=new int[nums.size()+1][target+1];
        for(int[] c:memo){
            Arrays.fill(c,-1);
        }
        return nhelper(nums1,target,0,memo);
    }
    public static int nhelper(int[] nums,int target,int i,int[][] memo){
        if(target==0){
            return 0;
        }
        if(i==nums.length || target<0){
            return -1;
        }
        if(memo[i][target]!=-1){
            return memo[i][target];
        }
        int ans1=Integer.MIN_VALUE;
        if(target>=nums[i]){
            int a=nhelper(nums,target-nums[i],i+1,memo);
            if(a!=-1){
                ans1=1+a;
            }
        }
        int ans2=nhelper(nums,target,i+1,memo);
        memo[i][target]=Math.max(ans1,ans2);
        return Math.max(ans1,ans2);
    }
    public static int nhelper2(int[] nums,int target){
        int[][] dp=new int[nums.length+1][target+1];
        for(int i=0;i<=target;i++){
            Arrays.fill(dp[nums.length],-1);
        }
        dp[nums.length][0]=0;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=1;j<=target;j++){
                int ans1=Integer.MIN_VALUE;
                if(j>=nums[i]){
                    int a=dp[i+1][j-nums[i]];
                    if(a!=-1){
                        ans1=1+a;
                    }
                }
                int ans2=dp[i+1][j];
                dp[i][j]=Math.max(ans1,ans2);
            }
        }
        return dp[0][target];
    }
//    public static void main(String[] args) {
//        int[]
//    }
}

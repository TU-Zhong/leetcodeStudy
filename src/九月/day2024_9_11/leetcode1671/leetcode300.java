package 九月.day2024_9_11.leetcode1671;

public class leetcode300 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int max=1;
        for(int i=nums.length-1;i>=0;i--){
            dp[i]=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={7,7,7,7,7,7,7};
        int ans=lengthOfLIS(nums);
        System.out.println(ans);
    }
}

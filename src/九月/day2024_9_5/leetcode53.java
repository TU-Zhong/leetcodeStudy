package 九月.day2024_9_5;

public class leetcode53 {
    public static int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,maxSubArrayhelper(nums,i));
        }
        return max;
    }
    public static int maxSubArrayhelper(int[] nums,int index){
        if(index>=nums.length){
            return 0;
        }
        int next=maxSubArrayhelper(nums,index+1);
        return next>0?next+nums[index]:nums[index];
    }
    public static int maxSubArrayhelper(int[] nums){
        int[] dp=new int[nums.length+1];
        int max=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            dp[i]=dp[i+1]>0?dp[i+1]+nums[i]:nums[i];
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public static int maxSubArrayhelper2(int[] nums){
        int currentmax=nums[0];
        int globalmax=nums[0];
        for(int i=1;i<nums.length;i++){
            currentmax=Math.max(currentmax+nums[i],nums[i]);
            globalmax=Math.max(globalmax,currentmax);
        }
        return globalmax;
    }

}

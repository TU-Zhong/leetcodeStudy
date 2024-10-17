package 九月.day2024_9_26;

public class leetcode494 {
    public static int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWayshelper(nums,target,0);
    }
    public static int findTargetSumWayshelper(int[] nums,int target,int i){
        if(target==0 && i==nums.length){
            return 1;
        }
        if(i==nums.length){
            return 0;
        }
        int ans1=findTargetSumWayshelper(nums,target-nums[i],i+1);
        int ans2=findTargetSumWayshelper(nums,target+nums[i],i+1);
        return ans1+ans2;
    }
}

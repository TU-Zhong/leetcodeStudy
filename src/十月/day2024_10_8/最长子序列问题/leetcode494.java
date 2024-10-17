package 十月.day2024_10_8.最长子序列问题;

public class leetcode494 {
    public static int findTargetSumWays(int[] nums, int target) {
        return nhelper(nums,target,0);
    }
    public static int nhelper(int[] nums,int target,int i){
        if(i==nums.length){
            return target==0?1:0;
        }
        int ans1=nhelper(nums,target-nums[i],i+1);
        int ans2=nhelper(nums,target+nums[i],i+1);
        return ans1+ans2;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        int target=3;
        int ans=findTargetSumWays(nums,target);
        System.out.println(ans);
    }
}

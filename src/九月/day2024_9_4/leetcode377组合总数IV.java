package 九月.day2024_9_4;

public class leetcode377组合总数IV {
    public static int combinationSum4(int[] nums, int target) {
        return combinationSum4helper(nums,target,0);
    }
    public static int combinationSum4helper(int[] nums,int target,int index){
        if(index==target){
            return 1;
        }
        if(index>target){
            return 0;
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=combinationSum4helper(nums,target,index+nums[i]);
        }
        return ans;
    }
public static int combinationSum4helper(int[] nums,int target){
        int[] dp=new int[target+1];
        dp[target]=1;
        for(int i=target-1;i>=0;i--){
            for(int j=0;j<nums.length;j++){
                if(i+nums[j]<=target){
                    dp[i]+=dp[i+nums[j]];
                }
            }
        }
        return dp[0];
}
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int target=4;
        int ans=combinationSum4(nums,target);
        int ans2=combinationSum4helper(nums,target);
        System.out.println(ans);
        System.out.println(ans2);
    }
}

package 九月.day2024_9_27;

public class leetcode209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0;
        int ans=nums.length+1;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum-nums[left]>=target){
                sum-=nums[left];
                left++;
            }
            if(sum>=target){
                ans=Math.min(ans,right-left+1);
            }
        }
        return ans==nums.length+1?0:ans;
    }

    public static void main(String[] args) {
        int target=7;
        int[] nums={2,3,1,2,4,3};
        int ans=minSubArrayLen(target,nums);
        System.out.println(ans);

    }
}

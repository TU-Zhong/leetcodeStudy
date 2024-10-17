package 九月.day2024_9_5;

public class leetcode918环形数组最大子数组和 {
    public static int maxSubarraySumCircular(int[] nums){
        int currentMax=nums[0];
        int globalMax=nums[0];
        int currentMin=nums[0];
        int globalMin=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            currentMax=Math.max(currentMax+nums[i],nums[i]);
            globalMax=Math.max(globalMax,currentMax);
            currentMin=Math.min(currentMin+nums[i],nums[i]);
            globalMin=Math.min(globalMin,currentMin);
            sum+=nums[i];
        }
        return sum==globalMin?globalMax:Math.max(globalMax,sum-globalMin);
    }

    public static void main(String[] args) {
        int[] nums={5,-3,5};
        int ans=maxSubarraySumCircular(nums);
        System.out.println(ans);
    }
}

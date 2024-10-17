package 九月.day2024_9_5;

public class leetcode1749 {
    public static int maxAbsoluteSum(int[] nums) {
        int currentMax=nums[0];
        int globalMax=nums[0];
        int currentMin=nums[0];
        int globalMin=nums[0];
        for(int i=1;i<nums.length;i++){
            currentMax=Math.max(currentMax+nums[i],nums[i]);
            currentMin=Math.min(currentMin+nums[i],nums[i]);
            globalMax=Math.max(globalMax,currentMax);
            globalMin=Math.min(globalMin,currentMin);
        }
        return Math.max(Math.abs(globalMax),Math.abs(globalMin));
    }
}

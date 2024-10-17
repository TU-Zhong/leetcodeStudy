package 九月.day2024_9_26;

public class leetcode53 {
    public static int maxSubArray(int[] nums){
        int current=Integer.MIN_VALUE/2;
        int max=Integer.MIN_VALUE/2;
        for(int i:nums){
            current=Math.max(current+i,i);
            max=Math.max(max,current);
        }
        return max;
    }
}

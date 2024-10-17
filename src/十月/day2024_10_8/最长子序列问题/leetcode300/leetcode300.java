package 十月.day2024_10_8.最长子序列问题.leetcode300;

public class leetcode300 {
    public static int lengthOfLIS(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,1+lengthOfLIShelper(nums,i+1,nums[i]));
        }
        return max;
    }
    public static int lengthOfLIShelper(int[] nums,int i,int pre){
        if(i==nums.length){
            return 0;
        }
        if(nums[i]<=pre){
            return lengthOfLIShelper(nums,i+1,pre);
        }
        return Math.max(lengthOfLIShelper(nums,i+1,pre),1+lengthOfLIShelper(nums,i+1,nums[i]));
    }

    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        int ans=lengthOfLIS(nums);
        int ans2=leetcode300_2.lengthOfLIS(nums);
        int ans3=leetcode300_2.length(nums);
        System.out.println(ans2);
        System.out.println(ans);
        System.out.println(ans3);
    }
}

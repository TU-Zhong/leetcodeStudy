package 十月.day2024_10_9;

import java.util.List;

public class leetcode2915Veryimportant {
//    public static int lengthOfLongestSubsequence(List<Integer> nums2, int target){
//        int[] nums=new int[nums2.size()];
//        for(int i=0;i<nums2.size();i++){
//            nums[i]=nums2.get(i);
//        }
//        return nhelper(nums,target,0);
//    }
    public static int nhelper(int[] nums,int target,int index){
        if(target==0){
            return 0;
        }
        if(index==nums.length || target<0){
            return -1;
        }
        if(target<nums[index]){
            return nhelper(nums,target,index+1);
        }
        int a=nhelper(nums,target-nums[index],index+1);
        int b=nhelper(nums,target,index+1);
        return a==-1?b:Math.max(1+a,b);
    }
    public static int lengthOfLongestSubsequence(List<Integer> nums2, int target){
        int[] nums=new int[nums2.size()];
        for(int i=0;i<nums2.size();i++){
            nums[i]=nums2.get(i);
        }
        int[][] dp=new int[target+1][nums.length+1];
        for(int i=1;i<=target;i++){
            dp[i][nums.length]=-1;
        }
        for(int i=1;i<=target;i++){
            for(int j=nums.length-1;j>=0;j--){
                //完全按照递归函数来写的，当i<nums[j]的时候，就会得到-1,对应递归函数中的database target<0,其余全部按照递归函数来改写
                int a=i>=nums[j]?dp[i-nums[j]][j+1]:-1;
                int b=dp[i][j+1];
                dp[i][j]=a==-1?b:Math.max(1+a,b);
            }
        }
        return dp[target][0];
    }
    public static void main(String[] args) {

    }
}

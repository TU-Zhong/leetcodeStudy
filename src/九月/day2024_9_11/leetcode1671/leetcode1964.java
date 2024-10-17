package 九月.day2024_9_11.leetcode1671;

import java.util.Arrays;

public class leetcode1964 {
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] position=new int[obstacles.length];
        int[] dp=new int[obstacles.length];
        Arrays.fill(position,Integer.MAX_VALUE);
        int pos=0;
        for(int i=0;i<obstacles.length;i++){
            pos=binarySearch(position,obstacles[i]);
            position[pos]=obstacles[i];
            dp[i]=pos+1;
        }
        return dp;
    }
    public static int binarySearch(int[] nums,int target){
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums={2,2,1};
        int[] ans=longestObstacleCourseAtEachPosition(nums);
        for(int c:ans){
            System.out.printf(c+" ");
        }
    }
}

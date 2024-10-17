package 十月.day2024_10_8.最长子序列问题.leetcode300;

import java.util.Arrays;

public class leetcode300最长递增子序列 {
    public static int lengthOfLIS(int[] nums) {
        int[] arr=new int[nums.length];
        Arrays.fill(arr,Integer.MAX_VALUE);
        int max=0;
        for(int c:nums){
            int ans=BinarySearch(arr,c);
            max=Math.max(ans,max);
            arr[ans]=c;
        }
        return max+1;
    }
    public static int BinarySearch(int[] nums,int c){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<c){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
//        System.out.println(left);
        return left;
    }
    public static void main(String[] args) {
        int[] nums={0,1,0,3,2,3};
        int ans=lengthOfLIS(nums);
        System.out.println(ans);
    }
}

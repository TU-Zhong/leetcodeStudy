package 十月.day2024_10_8.最长子序列问题;

import java.util.Arrays;

public class leetcode1671 {
    public static int minimumMountainRemovals(int[] nums) {
        int[] rise=new int[nums.length];
        int[] down=new int[nums.length];
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        Arrays.fill(rise,Integer.MAX_VALUE);
        Arrays.fill(down,Integer.MAX_VALUE);
        for(int i=0;i<nums.length-1;i++){
            int index=BinarySearch(rise,nums[i]);
            rise[index]=nums[i];
            left[i]=index+1;
        }
        for(int i=nums.length-1;i>0;i--){
            int index=BinarySearch(down,nums[i]);
            down[index]=nums[i];
            right[i]=index+1;
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(left[i]!=1&&right[i]!=1){
                max=Math.max(left[i]+right[i]-1,max);
            }
        }
        return nums.length-max;
    }
    public static int BinarySearch(int[] nums,int c){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=c){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={100,92,89,77,74,66,64,66,64};
        int ans=minimumMountainRemovals(nums);
        System.out.println(ans);
    }
}

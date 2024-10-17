package 十月.day2024_10_8.最长子序列问题.leetcode673;

import java.util.Arrays;

public class leetcode673最长递增子序列的个数 {
    public static int findNumberOfLIS(int[] nums) {
        int[] arr=new int[nums.length];
        Arrays.fill(arr,Integer.MAX_VALUE/2);
        int max=0;
        int ans=0;
        for(int c:nums){
            int index=BinarySearch(arr,c);
            arr[index]=c;
            max=Math.max(max,index);
        }
        int maxlen=max+1;
        Arrays.fill(arr,Integer.MAX_VALUE);
        for(int c:nums){
            int index=BinarySearch(arr,c);
            arr[index]=c;
            if(index+1==maxlen){
                ans++;
            }
        }
        return ans;
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
        System.out.println(left);
        return left;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,4,7};
        int ans=findNumberOfLIS(nums);
        System.out.println(ans);
    }
}

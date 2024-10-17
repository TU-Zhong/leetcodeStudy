package 九月.day2024_9_12;

import java.util.Arrays;

public class leetcode2576_3 {
    public static int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left=0,right=nums.length/2;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(nums,mid)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right*2;
    }
    public static boolean check(int[] nums,int k){
        for(int i=0;i<k;i++){
            if(nums[i]*2>nums[nums.length-k+i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={1,3,8,9,10};
        int ans=maxNumOfMarkedIndices(nums);
        System.out.println(ans);
    }
}

package 十月.day2024_10_8.最长子序列问题;

import java.util.Arrays;
import java.util.List;

public class leetcode2826 {
    public static int minimumOperations(List<Integer> nums) {
        int[] arr=new int[nums.size()];
        Arrays.fill(arr,Integer.MAX_VALUE);
        int max=0;
        for(int c:nums){
            int index=BinarySearch(arr,c);
            arr[index]=c;
            max=Math.max(max,index);
        }
        return nums.size()-(max+1);
    }
    public static int BinarySearch(int[] arr,int c){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]<=c){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={2,2,2,2,3,3};
//        int ans=minimumOperations(nums);
//        System.out.println(ans);
    }
}

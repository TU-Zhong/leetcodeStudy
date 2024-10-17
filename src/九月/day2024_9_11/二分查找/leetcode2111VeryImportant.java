package 九月.day2024_9_11.二分查找;

import java.util.Arrays;

public class leetcode2111VeryImportant {
    //要将这个存储子序列的数组弄小点，否则很容易超时
    public static int kIncreasing(int[] arr, int k) {
        int[] position=new int[arr.length/k+5];
        int pos=0;
        int ans=0;
        //根据题意，将整个数组分成k组，很明显每组并不相关，分别计算以每组的最长子序列的大小，然后相加。
        for(int j=0;j<k;j++){
            Arrays.fill(position,Integer.MAX_VALUE);
            int max=0;
            for(int i=j;i<arr.length;i+=k){
                pos=binarySearch(position,arr[i]);
                position[pos]=arr[i];
                max=Math.max(max,pos+1);
            }
            ans+=max;
        }
        return arr.length-ans;
    }
    //找到第一个大于target的下标
    public static int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=target){
                left=mid+1;
            }else{
                if(mid==0 || nums[mid-1]<=target){
                    return mid;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={4,1,5,2,6,2};
        int ans=kIncreasing(nums,3);
        System.out.println(ans);
    }
}

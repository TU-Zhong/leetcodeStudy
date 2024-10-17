package 九月.day2024_9_11.leetcode1671;

import java.util.Arrays;

public class leetcode1671_2 {
    public static int minimumMountainRemovals(int[] nums) {
        int[] dpleft=new int[nums.length];
        int[] dpright=new int[nums.length];
        Arrays.fill(dpleft,1);
        Arrays.fill(dpright,1);
        //找到以当前下标为结尾的最长子序列长度
        for(int i=0;i<nums.length;i++){
            dpleft[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dpleft[i]=Math.max(dpleft[j]+1,dpleft[i]);
                }
            }
        }
        //找到以当前下标开头的最长子序列的长度
        for(int i=nums.length-1;i>=0;i--){
            dpright[i]=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    dpright[i]=Math.max(dpright[j]+1,dpright[i]);
                }
            }
        }
        int max=0;
        for(int i=1;i<nums.length-1;i++){
            if(dpleft[i]==1||dpright[i]==1){
                continue;
            }
            max=Math.max(max,dpleft[i]+dpright[i]-1);
        }
        return nums.length-max;
    }

    public static void main(String[] args) {
        int[] nums={2,1,1,5,6,2,3,1};
        int ans=minimumMountainRemovals(nums);
        System.out.println(ans);
    }
}

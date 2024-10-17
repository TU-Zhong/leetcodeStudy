package 九月.day2024_9_6.leetcode3176;

import java.util.Arrays;

public class leetcode3176_3 {
    public static int maximumLength(int[] nums, int k) {
        int max=0;
        int[][] memo=new int[nums.length][k+1];
        for(int[] c:memo){
            Arrays.fill(c,-1);
        }
        for(int i=0;i<nums.length;i++){
            max=Math.max(maximumLengthhelper(nums,k,i,memo),max);
        }
        return max+1;
    }
    //以index开头的满足要求的子序列的最大长度是多少
    public static int maximumLengthhelper(int[] nums,int k,int index,int[][] memo){
        if(index>=nums.length || k<0){
            return 0;
        }
        if(memo[index][k]!=-1){
            return memo[index][k];
        }
        int max=0;
        for(int i=index+1;i<nums.length;i++){
            int ans=0;
            if(nums[i]!=nums[index]){
                if(k-1>=0 ){
                    ans= maximumLengthhelper(nums,k-1,i,memo)+1;
                }
            }else if(nums[i]==nums[index]){
                ans=maximumLengthhelper(nums,k,i,memo)+1;
            }
            max=Math.max(ans,max);
        }
        return memo[index][k]=max;
    }

    public static void main(String[] args) {
        int[] nums={2,15};
        int k=2;
        System.out.println(maximumLength(nums,k));
    }
}

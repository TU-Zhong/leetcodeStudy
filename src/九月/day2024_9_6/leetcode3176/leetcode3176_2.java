package 九月.day2024_9_6.leetcode3176;

import java.util.Arrays;

public class leetcode3176_2 {
    public static int maximumLength(int[] nums, int k) {
        int max=0;
        int[][][] memo=new int[nums.length][k+1][nums.length+1];
        for(int[][] c:memo){
            for(int[] b:c){
                Arrays.fill(b,-1);
            }
        }
        for(int i=0;i<nums.length;i++){
            int ans=maximumLengthhelper(nums,k,i,0,1,memo);
            max=Math.max(max,ans);
        }
        return max;
    }
    //以index开头的满足要求的子序列的最大长度是多少
    public static int maximumLengthhelper(int[] nums,int k,int index,int k2,int length,int[][][] memo){
        if(k2>k || index>=nums.length){
            return length;
        }
        long label=(long)index<<30 | (long) k2 <<20 | (long) length <<10;
        if(memo[index][k2][length]!=-1){
            return memo[index][k2][length];
        }
        int max=0;
        for(int i=index+1;i<nums.length;i++){
            //选择i元素
            int ans=0;
            if(nums[i]!=nums[index] && k2+1<=k){
                ans=maximumLengthhelper(nums,k,i,k2+1,length+1,memo);
            }else if(nums[i]==nums[index]){
                ans=maximumLengthhelper(nums,k,i,k2,length+1,memo);
            }
            max=Math.max(max,ans);
        }
        memo[index][k2][length]=max;
        return max==0?length:max;
    }
}

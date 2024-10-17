package 九月.day2024_9_7.test414;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static long findMaximumScore(List<Integer> nums) {
        long[] memo=new long[nums.size()];
        Arrays.fill(memo,Long.MIN_VALUE);
        return findMaximumScorehelper(nums,0,memo);
    }
    public static long findMaximumScorehelper(List<Integer> nums,int index,long[] memo){
        if(index>=nums.size()){
            return 0;
        }
        if(memo[index]!=Long.MIN_VALUE){
            return memo[index];
        }
        long max=0;
        for(int i=index+1;i<nums.size();i++){
            long ans=findMaximumScorehelper(nums,i,memo)+(long)(i-index)*nums.get(index);
            max= Math.max(max,ans);
        }
        return memo[index]=max;
    }
    public static int[] listToIntArray(List<Integer> list) {
        int[] array = new int[list.size()];  // 创建对应大小的数组
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);  // 将每个元素复制到数组中
        }
        return array;  // 返回转换后的数组
    }
    public static long findMaximumScorehelper(List<Integer> nums){
        int[] nums2=listToIntArray(nums);
        long[] dp=new long[nums.size()+1];
        for(int index=nums2.length;index>=0;index--){
            for(int i=index+1;i<nums2.length;i++){
                long ans=dp[i]+(long)(i-index)*nums2[index];
                dp[index]=Math.max(dp[index],ans);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums={4,3,1,3,2};
        List<Integer> list=new ArrayList<>();
        for(int c:nums){
            list.add(c);
        }
        long ans=findMaximumScorehelper(list);
        System.out.println(ans);
    }
}

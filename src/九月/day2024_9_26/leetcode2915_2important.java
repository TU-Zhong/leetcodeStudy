package 九月.day2024_9_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode2915_2important {
    public static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        return nhelper(nums,0,target);
    }
    public static int nhelper(List<Integer> nums,int i,int target){
        if(target==0){
            return 0;
        }
        if(i==nums.size()){
            return -1;
        }
        //选当前数
        int ans1=Integer.MIN_VALUE;
        if(target>=nums.get(i)){
            int a=nhelper(nums,i+1,target-nums.get(i));
            if(a!=-1){
                ans1=1+nhelper(nums,i+1,target-nums.get(i));
            }
        }
        int ans2=nhelper(nums,i+1,target);
        return Math.max(ans1,ans2);
    }
    public static int nhelper2(List<Integer> nums,int target){
        int[][] dp=new int[nums.size()+1][target+1];
        Arrays.fill(dp[nums.size()],-1);
        dp[nums.size()][0]=0;
        //上面遍历容量
        for(int i=1;i<=target;i++){
            //下面遍历下标
            for(int j=nums.size()-1;j>=0;j--){
                int ans1=Integer.MIN_VALUE;
                if(i>=nums.get(j)){
                    if(dp[j+1][i-nums.get(j)]!=-1){
                        ans1=1+dp[j+1][i-nums.get(j)];
                    }
                }
                int ans2=dp[j+1][i];
                dp[j][i]=Math.max(ans1,ans2);
            }
        }
        return dp[0][target];
    }
    public static void main(String[] args) {
        List<Integer> nums=new ArrayList<>();
        int[] nums2={1,1,5,4,5};
        int target=3;
        for(int c:nums2){
            nums.add(c);
        }
        int ans=lengthOfLongestSubsequence(nums,target);
        int ans2=nhelper2(nums,target);
        System.out.println(ans);
        System.out.println(ans2);
    }
}

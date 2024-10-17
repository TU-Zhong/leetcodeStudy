package 十月.day2024_10_8.最长子序列问题.leetcode673;

import java.util.Arrays;

public class leetcode673 {
    public static int findNumberOfLIS(int[] nums) {
        int[] dplen=new int[nums.length];
        int[] dpcnt=new int[nums.length];
        Arrays.fill(dpcnt,1);
        Arrays.fill(dplen,1);
        int max=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dplen[j]+1>dplen[i]){
                        dplen[i]=dplen[j]+1;
                        dpcnt[i]=dpcnt[j];
                    }else if(dplen[j]+1==dplen[i]){
                        dpcnt[i]+=dpcnt[j];
                    }
                }
            }
            max=Math.max(max,dplen[i]);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=dplen[i]==max?dpcnt[i]:0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={2,2,2,2,2};
        int ans=findNumberOfLIS(nums);
        System.out.println(ans);
    }
}

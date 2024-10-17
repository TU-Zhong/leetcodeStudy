package 十月.day2024_10_8.背包;

public class leetcode494 {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum=target;
        for(int c:nums){
            sum+=c;
        }
        if( sum<0 || sum%2==1 ){
            return 0;
        }
        sum/=2;
        return nhelper(nums,sum,0);
    }
    public static int nhelper(int[] nums,int sum,int index){
        if(index<0){
            return sum==0?1:0;
        }
        if(sum<nums[index]){
            return nhelper(nums,sum,index-1);
        }
        return nhelper(nums,sum-nums[index],index-1)+nhelper(nums,sum,index-1);
    }
}

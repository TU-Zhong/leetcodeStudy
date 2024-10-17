package 十月.day2024_10_11;

public class leetcode1049 {
    public static int lastStoneWeightII1(int[] stones) {
        int sum=0;
        for(int c:stones){
            sum+=c;
        }
        int target=sum/2;
        return sum-2*nhelper(stones,target,0);
    }
    public static int nhelper(int[] nums,int target,int index){
        if(index==nums.length){
            return 0;
        }
        if(target<0){
            return -1;
        }
        if(target<nums[index]){
            return nhelper(nums,target,index+1);
        }
        int nottake=nhelper(nums,target,index+1);
        int take=nhelper(nums,target-nums[index],index+1);
        return Math.max(take==-1?0:nums[index]+take,nottake);
    }
    public static int lastStoneWeightII(int[] stones) {
        //这里虽然递归里面有target<0时初始化为-1,但说到底构建的dp表，列为target(左边)，行为index,target根本不可能为负数，所以不用初始化
        int sum=0;
        for(int c:stones){
            sum+=c;
        }
        int target=sum/2;
        int[][] dp=new int[target+1][stones.length+1];
        for(int i=0;i<=target;i++){
            for(int j=stones.length-1;j>=0;j--){
                if(i<stones[j]){
                    dp[i][j]=dp[i][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i][j+1],stones[j]+dp[i-stones[j]][j+1]);
                }
            }
        }
        return sum-2*dp[target][0];
    }
}

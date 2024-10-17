package 十月.day2024_10_10;

public class leetcode416分割等和子集 {
    public static boolean canPartition1(int[] nums){
        int sum=0;
        for(int c:nums){
            sum+=c;
        }
        if(sum%2==1){
            return false;
        }
        sum/=2;
        return nhelper(nums,sum,0);
    }
    public static boolean nhelper(int[] nums,int target,int index){
        if(target==0){
            return true;
        }
        if(target<0 || index==nums.length){
            return false;
        }
        if(target<nums[index]){
            return nhelper(nums,target,index+1);
        }
        boolean a=nhelper(nums,target-nums[index],index+1);
        boolean b=nhelper(nums,target,index+1);
        return a||b;
    }
    public static boolean canPartition(int[] nums){
        int sum=0;
        for(int c:nums){
            sum+=c;
        }
        if(sum%2==1){
            return false;
        }
        sum/=2;
        boolean[][] dp=new boolean[sum+1][nums.length+1];
        for(int i=0;i<=nums.length;i++){
            dp[0][i]=true;
        }
        for(int i=1;i<=sum;i++){
            for(int j=nums.length-1;j>=0;j--){
                if(i<nums[j]){
                    dp[i][j]=dp[i][j+1];
                }else{
                    dp[i][j]=dp[i-nums[j]][j+1]||dp[i][j+1];
                }
            }
        }
        return dp[sum][0];
    }
}

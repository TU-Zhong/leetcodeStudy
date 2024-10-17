package 九月.day2024_9_26;

public class leetcode416 {
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int c:nums){
            sum+=c;
        }
        if(sum%2==1){
            return false;
        }
        return canPartitionhelper(nums,0,sum/2);
    }
    public static boolean canPartitionhelper(int[] nums,int i,int target){
        if(target==0){
            return true;
        }
        if(target <0 || i==nums.length){
            return false;
        }
        boolean ans1=canPartitionhelper(nums,i+1,target-nums[i]);
        boolean ans2=canPartitionhelper(nums,i+1,target);
        return ans1||ans2;
    }
    public static boolean canPartitionhelper2(int[] nums){
        int sum=0;
        for(int c:nums){
            sum+=c;
        }
        if(sum%2==1){
            return false;
        }
        int target=sum/2;
        boolean[][] dp=new boolean[nums.length+1][target+1];
        for(int i=0;i<=nums.length;i++){
            dp[i][0]=true;
        }
        //先遍历下标
        for(int i=nums.length-1;i>=0;i--){
            for(int j=1;j<=target;j++){
                //选当前的数
                boolean ans1=j-nums[i]<0?false:dp[i+1][j-nums[i]];
                boolean ans2=dp[i+1][j];
                dp[i][j]=ans1||ans2;
            }
        }
        return dp[0][target];
    }
    public static void main(String[] args) {
        int[] nums={1,2,5};
        System.out.println(canPartitionhelper2(nums));
    }
}

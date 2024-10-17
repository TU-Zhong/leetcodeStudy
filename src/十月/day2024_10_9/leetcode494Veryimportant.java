package 十月.day2024_10_9;

public class leetcode494Veryimportant {
//    public static int findTargetSumWays(int[] nums, int target) {
//        for(int c:nums){
//            target+=c;
//        }
//        if(target%2==1 || target<0){
//            return 0;
//        }
//        int s=target/2;
//        return nhelper(nums,s,0);
//    }
    public static int nhelper(int[] nums,int target,int index){

        //这个database只考虑了最后一列的情况，并没有考虑第一行的情况，不要搞混淆了

        if(index==nums.length){
            return target==0?1:0;
        }
        if(target<nums[index]){
            return nhelper(nums,target,index+1);
        }
        return nhelper(nums,target,index+1)+nhelper(nums,target-nums[index],index+1);
    }
    public static int findTargetSumWays(int[] nums,int target){
        for(int c:nums){
            target+=c;
        }
        if(target<0 || target%2==1){
            return 0;
        }
        target/=2;
        int[][] dp=new int[target+1][nums.length+1];
        dp[0][nums.length]=1;
        //这个database只考虑了最后一列的情况，并没有考虑第一行的情况，不要搞混淆了
        //要从第一行开始进行填表
        for(int i=0;i<=target;i++){
            for(int j=nums.length-1;j>=0;j--){
                if(i<nums[j]){
                    dp[i][j]=dp[i][j+1];
                }else{
                    dp[i][j]=dp[i][j+1]+dp[i-nums[j]][j+1];
                }
            }
        }
        for(int[] c:dp){
            for(int d:c){
                System.out.printf(d+" ");
            }
            System.out.println();
        }
        return dp[target][0];
    }
    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        int target=3;
        int ans=findTargetSumWays(nums,target);
        System.out.println(ans);    }
}

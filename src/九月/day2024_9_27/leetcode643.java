package 九月.day2024_9_27;

public class leetcode643 {
    public static double findMaxAverage(int[] nums, int k) {
        int left=0;
        int len=0;
        int sum=0;
        //double ans=DOUBLE.min_value竟然直接等于0
        double ans=-200000;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            len=right-left+1;
            if(len>k){
                //len记得减减
                len--;
                sum-=nums[left];
                //left记得加加
                left++;
            }
            if(len==k){
                ans=Math.max(ans,sum*1.0/k);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={7,4,5,8,8,3,9,8,7,6};
        int k=7;
        double ans=findMaxAverage(nums,k);
        System.out.println(ans);
    }
}

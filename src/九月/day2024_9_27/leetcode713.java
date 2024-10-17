package 九月.day2024_9_27;

public class leetcode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<1){
            return 0;
        }
        int left=0;
        int sum=1;
        int ans=0;
        for(int right=0;right<nums.length;k++){
            sum*=nums[right];
            while(sum>=k){
                sum/=nums[left++];
                ans++;
            }
        }
        return ans;
    }
}

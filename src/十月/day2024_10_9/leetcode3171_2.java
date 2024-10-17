package 十月.day2024_10_9;

public class leetcode3171_2 {
    public int minimumDifference(int[] nums, int k) {
        int left=0;
        int rightOr=0;
        int bottom=0;
        int ans=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            rightOr|=nums[right];
            while(left<=right && (nums[left] | rightOr )>k ){
                ans=Math.min(ans,(nums[left]|rightOr)-k);
                if(bottom <= left){
                    for(int i=right-1;i>left;i--){
                        nums[i]|=nums[i+1];
                    }
                    bottom=right;
                    rightOr=0;
                }
                left++;
            }
            if(left<=right){
                ans=Math.min(ans,k-(nums[left]|rightOr));
            }
        }
        return ans;
    }
}

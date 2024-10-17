package 九月.day2024_9_11.leetcode1671;

public class 最长递增子序列 {
    //以当前数开头的最长递增子序列
    public static int minimumMountainRemovals(int[] nums) {
        return minimumMountainRemovalshelper(nums,0)+1;
    }
    public static int minimumMountainRemovalshelper(int[] nums,int index){
        if(index>=nums.length){
            return 0;
        }
        int max=0;
        for(int i=index+1;i<nums.length;i++){
            int ans1=0;
            if(nums[i]>nums[index]){
                ans1=1+minimumMountainRemovalshelper(nums,i);
            }
            max=Math.max(max,ans1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,8,5,6,7};
        int ans=minimumMountainRemovals(nums);
        System.out.println(ans);
    }
}

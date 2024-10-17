package 九月.day2024_9_26;

public class leetcode2915 {
    public static int lengthOfLongestSubsequence(int[] nums2, int target) {
//        int[] nums2=new int[nums.size()];
//        int index=0;
//        for(int c:nums){
//            nums2[index++]=c;
//        }
        int max=0;
        for(int i=0;i<nums2.length;i++){
            max=Math.max(max,nhelper(nums2,1,i+1,target-nums2[i]));
        }
        return max==0?-1:max;
    }
    public static int nhelper(int[] nums,int len,int i,int target){
        if(target==0){
            return len;
        }
        if(i==nums.length || target<0){
            return 0;
        }
        int ans1=nhelper(nums,len+1,i+1,target-nums[i]);
        int ans2=nhelper(nums,len,i+1,target);
        return Math.max(ans1,ans2);
    }

    public static void main(String[] args) {
        int[] nums={3,5,2,3,4};
        int target=12;
        int ans=lengthOfLongestSubsequence(nums,target);
        System.out.println(ans);
    }
}

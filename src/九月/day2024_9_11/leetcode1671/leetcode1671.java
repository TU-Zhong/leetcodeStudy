package 九月.day2024_9_11.leetcode1671;

public class leetcode1671 {
    public static int minimumMountainRemovals(int[] nums) {
        int max=0;
        int left=0,left1=0;
        int right=0,right1=0;
        int index=0;
        for(int i=1;i<nums.length-1;i++){
            left=maxlenleft(nums,i);
            right=maxlenright(nums,i);
            if(left==1||right==1){
                continue;
            }
            if(left+right-1>max){
                index=i;
                left1=left;
                right1=right;
                max=left+right-1;
            }
        }
//        System.out.println(index);
//        System.out.println(left1+" , "+right1);
        return nums.length-max;
    }
    public static int maxlenright(int[] nums,int index){
        if(index>=nums.length){
            return 0;
        }
        int max=1;
        for(int i=index+1;i<nums.length;i++){
            int ans=0;
            if(nums[i]<nums[index]){
                ans=1+maxlenright(nums,i);
            }
            max=Math.max(max,ans);
        }
        return max;
    }
    public static int maxlenleft(int[] nums,int index){
        if(index<0){
            return 0;
        }
        int max=1;
        for(int i=index-1;i>=0;i--){
            int ans=0;
            if(nums[i]<nums[index]){
                ans=1+maxlenleft(nums,i);
            }
            max=Math.max(max,ans);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums={2,1,1,5,6,2,3,1};
        int ans=minimumMountainRemovals(nums);
        System.out.println(ans);
    }
}

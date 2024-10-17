package 九月.day2024_9_3;

import java.util.Arrays;

public class leetcode2708 {
    public static long maxStrength(int[] nums) {
        long sum=1;
        Arrays.sort(nums);
        int flag=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                sum*=nums[i];
                flag=1;
            }else if(nums[i]<0&&i+1<nums.length&&nums[i+1]<0){
                sum=sum*(long)nums[i]*nums[i+1];
                flag=1;
                i++;
            }
        }
        if(flag==-1){
            return nums[nums.length-1];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums={3,-1,-5,2,5,-9};
        long ans=maxStrength(nums);
        System.out.println(ans);
    }
}

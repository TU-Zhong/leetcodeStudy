package 九月.day2024_9_28;

import java.util.Arrays;

public class leetcode2090 {
    public static int[] getAverages(int[] nums, int k) {
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        int left=0;
        long sum=0;
        int index=k;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            int len=right-left+1;
            if(len==2*k+2){
                sum-=nums[left++];
                len--;
            }
            if(len==2*k+1 ){
                res[index++]=(int)(sum/len);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n=100000;
        int[] nums=new int[n];
        Arrays.fill(nums,10000);
        int k=40000;
        int[] res=getAverages(nums,k);
        for(int i=0;i<res.length;i++){

        }
    }
}

package 十月.day2024_10_16;

import java.util.Arrays;

public class leetcode3194 {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double res=(double)Integer.MAX_VALUE/2;
        int p1=0;
        int p2=nums.length-1;
        while(p1<p2){
            res=Math.min(res, (double) (nums[p1++] + nums[p2--]) /2);
        }
        return res;
    }

    public static void main(String[] args) {
    }
}

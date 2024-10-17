package 九月.day2024_9_7;

import java.util.Arrays;

public class leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int[] result=new int[nums.length];
        int index=0;
        for(int i=0;i<nums.length;i++){
            result[index++]=nums[i]*nums[i];
        }
        Arrays.sort(result);
        return result;
    }
}

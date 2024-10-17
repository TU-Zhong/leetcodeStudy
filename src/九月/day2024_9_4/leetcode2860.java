package 九月.day2024_9_4;

import java.util.Arrays;
import java.util.List;

public class leetcode2860 {
    public int countWays(List<Integer> nums) {
        int[] a=new int[nums.size()];
        int index=0;
        for(int c:nums){
            a[index++]=c;
        }
        Arrays.sort(a);
        int ans=a[0]>0?1:0;
        for(int i=1;i<a.length;i++){
            if(a[i-1]<i && a[i]>i){
                ans++;
            }
        }
        return ans+1;
    }

    public static void main(String[] args) {

    }
}

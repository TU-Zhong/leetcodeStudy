package 十月.day2024_10_10;

import java.util.Arrays;

public class leetcode3162 {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%k!=0){
                continue;
            }
            for(int j=0;j<nums2.length;j++){
                if( nums2[j]*k > nums1[i] ){
                    break;
                }
                if(nums1[i]%(nums2[j]*k)==0){
                    ans++;
                }
            }
        }
        return ans;
    }
}

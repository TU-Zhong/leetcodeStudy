package 十月.day2024_10_11;

import java.util.HashMap;

public class leetcode3164 {
    public static long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int c:nums1){
            if(c%k!=0){
                continue;
            }
            c/=k;
            for(int i=1;i*i<=c;i++){
                if(c%i==0){
                    map.merge(i,1,Integer::sum);
                    if(i*i!=c){
                        map.merge(c/i,1,Integer::sum);
                    }
                }
            }
        }
        long sum=0;
        for(int c:nums2){
            sum+=map.getOrDefault(c,0);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums1={1};
        int[] nums2={8};
        int k=1;
        long ans=numberOfPairs(nums1,nums2,k);
        System.out.println(ans);
    }
}

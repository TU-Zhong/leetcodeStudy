package 九月.day2024_9_25;

import java.util.Arrays;

public class leetcode3007 {
    public static long findMaximumNumber(long k, int x) {
        long left = 0;
        long right = (k + 1) << x;
        while (left <= right) {
            long mid = left+(right-left)/2;
            if (countdigitone(mid,x) <= k) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left-1;
    }
    private static long num;
    private static int x1;
    public static long countdigitone(long n,int x){
        int m=64-Long.numberOfLeadingZeros(n);
        num=n;
        x1=x;
        long[][] memo=new long[m+1][m+1];
        for(long[] c:memo){
            Arrays.fill(c,-1);
        }
        return countdigitonehelper(m-1,0,true,memo);
    }
    public static long countdigitonehelper(int i,int cnt,boolean islimit,long[][] memo){
        if(i<0){
            return cnt;
        }
        if(!islimit&&memo[i][cnt]!=-1){
            return memo[i][cnt];
        }
        long res=0;
        int up=islimit?(int)(num>>i)&1:1;
        for(int k=0;k<=up;k++){
            res+=countdigitonehelper(i-1,cnt+( k==1 && (i+1) % x1 ==0 ?1:0),islimit&&k==up,memo);
        }
        memo[i][cnt]=res;
        return res;
    }
    public static void main(String[] args) {
        long k=3278539330613L;
        int x=5;
        long ans=findMaximumNumber(k,x);
        System.out.println(ans);
    }
}

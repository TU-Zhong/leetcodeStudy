package 九月.day2024_9_7.test414;

import java.util.Arrays;

public class Q2 {
    public static int maxPossibleScore(int[] start, int d) {
        int n=start.length;
        Arrays.sort(start);
        int left=0;
        int right=(start[n-1]+d-start[0])/(n-1)+1;
        while(left+1<right){
            int mid=left+(right-left)/2;
            if(check(start,mid,d)){
                left=mid;
            }else{
                right=mid;
            }
        }
        return left;
    }
    public static boolean check(int[] start,int score,int d){
        int prex=Integer.MIN_VALUE;
        for(int s:start){
            int current=prex+score;
            if(current>s+d){
                return false;
            }
            prex= Math.max(s,current);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] start={2,6,13,13};
        int d=5;
        int ans=maxPossibleScore(start,d);
        System.out.println(ans);
    }
}

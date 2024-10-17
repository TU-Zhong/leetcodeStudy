package 九月.day2024_9_23;

import java.util.Arrays;

public class leetcode233 {
    public static int countDigitOne(int n) {
        char[] s=String.valueOf(n).toCharArray();
        int[][] memo=new int[s.length+1][s.length+1];
        for(int[] c:memo){
            Arrays.fill(c,-1);
        }
        return countDigitOnehelper(0,0,true,s,memo);
    }
    public static int countDigitOnehelper(int i,int cnt,boolean islimit,char[] s,int[][] memo){
        if(i==s.length){
            return cnt;
        }
        if(!islimit && memo[i][cnt]!=-1){
            return memo[i][cnt];
        }
        int res=0;
        int up=islimit?s[i]-'0':9;
        for(int k=0;k<=up;k++){
            res+=countDigitOnehelper(i+1,cnt+(k==1?1:0),islimit&k==up,s,memo);
        }
        memo[i][cnt]=res;
        return res;
    }

    public static void main(String[] args) {
        int n=100;
        int ans=countDigitOne(n);
        System.out.println(ans);
    }
}

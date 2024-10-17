package 九月.day2024_9_23;

import java.util.Arrays;

public class leetcode600 {
    public static int findIntegers(int n) {
        char[] s=Integer.toBinaryString(n).toCharArray();
        int[][] memo=new int[s.length+1][2];
        for(int[] c:memo){
            Arrays.fill(c,-1);
        }
        return findIntegershelper(0,0,true,s,memo);
    }
    public static int findIntegershelper(int i,int pre,boolean islimit,char[] s,int[][] memo){
        if(i==s.length){
            return 1;
        }
        if(!islimit && memo[i][pre]!=-1){
            return memo[i][pre];
        }
        int res=findIntegershelper(i+1,0,islimit&s[i]=='0',s,memo);
        int up=islimit?s[i]-'0':1;
        if(pre==0 && up==1){
            res+=findIntegershelper(i+1,1,islimit,s,memo);
        }
        memo[i][pre]=res;
        return res;
    }

    public static void main(String[] args) {
        int n=2;
        int ans=findIntegers(n);
        System.out.println(ans);
    }
}

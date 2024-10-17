package 九月.day2024_9_6.leetcode1143;

import java.util.Arrays;

public class leetcode1143最长公共子序列 {
    static String str1;
    static String str2;
    static String ans1="";
    public static int longestCommonSubsequence(String text1, String text2) {
        str1=text1;
        str2=text2;
        int[][] memo=new int[text1.length()][text2.length()];
        for(int[] c:memo){
            Arrays.fill(c,-1);
        }
        return longestCommonSubsequencehelper(0,0,memo);
    }
    public static int longestCommonSubsequencehelper(int i,int j,int[][] memo){
        if(i>=str1.length() || j>=str2.length()){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(str1.charAt(i)==str2.charAt(j)){
            return 1+longestCommonSubsequencehelper(i+1,j+1,memo);
        }
        memo[i][j]=Math.max(longestCommonSubsequencehelper(i+1,j,memo),longestCommonSubsequencehelper(i,j+1,memo));
        return memo[i][j];
    }

    public static void main(String[] args) {
        String s1= "ef";
        String s2="cef";
        int ans=longestCommonSubsequence(s1,s2);
        System.out.println(ans);
        System.out.println(ans1);
    }
}

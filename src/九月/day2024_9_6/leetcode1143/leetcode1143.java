package 九月.day2024_9_6.leetcode1143;

public class leetcode1143 {
    public static int longestCommonSubsequence(String text1, String text2){
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        //先初始化最后一行，text1在左，text2在上
        for(int i=text1.length()-1;i>=0;i--){
            for(int j=text2.length()-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        for(int[] s:dp){
            for(int c:s){
                System.out.printf(c+" ");
            }
            System.out.println();
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        longestCommonSubsequence("acde","ace");
    }
}

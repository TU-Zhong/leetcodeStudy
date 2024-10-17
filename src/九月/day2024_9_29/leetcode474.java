package 九月.day2024_9_29;

import java.util.Arrays;

public class leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] log=new int[strs.length][2];
        int index=0;
        for(String str:strs){
            for(int i=0;i<str.length();i++){
                log[index][str.charAt(i)-'0']++;
            }
            index++;
        }
        int[][][] memo=new int[strs.length][m+1][n+1];
        for(int[][] c:memo){
            for(int[] b:c){
                Arrays.fill(b,-1);
            }
        }
        return findMaxFormhelper(log,0,m,n,memo);
    }
    public static int findMaxFormhelper(int[][] log,int i,int m,int n,int[][][] memo){
        if(i==log.length && m>=0 && n>=0){
            return 0;
        }
        if(memo[i][m][n]!=-1){
            return memo[i][m][n];
        }
        int ans2=0;
        if(m>=log[i][0]&&n>=log[i][1]){
            ans2=1+findMaxFormhelper(log,i+1,m-log[i][0],n-log[i][1],memo);
        }
        int ans1=findMaxFormhelper(log,i+1,m,n,memo);
        memo[i][m][n]=Math.max(ans1,ans2);
        return Math.max(ans1,ans2);
    }

}

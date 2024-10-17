package 九月.day2024_9_21数位dp;

import java.util.Arrays;

public class leetcode2719 {
    private static final int MOD=1000000007;
    public static int count(String num1, String num2, int min_sum, int max_sum) {
        int ans=cal(num2,min_sum,max_sum)-cal(num1,min_sum,max_sum)+MOD;
        char[] s=num1.toCharArray();
        int sum=0;
        for(int i=0;i<s.length;i++){
            sum+=s[i]-'0';
        }
        if(sum<=max_sum&&sum>=min_sum){
            ans++;
        }
        return ans%MOD;
    }
    public static int cal(String num,int min_sum,int max_sum){
        char[] s=num.toCharArray();
        int[][] memo=new int[num.length()][Math.min(9*num.length(),max_sum)+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        int ans= calhelper(0,0,true,min_sum,max_sum,s,memo);
        return ans;
    }
    public static int calhelper(int i,int sum,boolean islimit,int min_sum,int max_sum,char[] s,int memo[][]){
        if(sum>max_sum){
            return 0;
        }
        if(i==s.length ){
            return sum>=min_sum? 1:0;
        }
        if(!islimit && memo[i][sum]!=-1){
            return memo[i][sum];
        }
        int res=0;
        int up=islimit?s[i]-'0':9;
        for(int k=0;k<=up;k++){
            res=(res+calhelper(i+1,sum+k,islimit &k==up,min_sum,max_sum,s,memo))%MOD;
        }
        if(!islimit){
            memo[i][sum]=res;
        }
        return res;
    }

    public static void main(String[] args) {
        String num1="1";
        String num2="5";
        int min_num=1;
        int max_num=5;
        int ans=count(num1,num2,min_num,max_num);
        System.out.println(ans);
    }
}

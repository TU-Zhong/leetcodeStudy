package 九月.day2024_9_21数位dp;

import java.util.Arrays;

public class leetcode2376 {
    public static int countSpecialNumbers(int n) {
        char[] s=String.valueOf(n).toCharArray();
        int[][] memo=new int[s.length][1<<10];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return countSpecialNumbershelper(0,0,true,false,s,memo);
    }
    public static int countSpecialNumbershelper(int i,int mask,boolean islimit,boolean isNum,char[] s,int[][] memo){
        if(i==s.length){
            return isNum?1:0;
        }
        //如果i前面的位数都不相等（即不与n的对应位上的数一一对应）如n=1234,当前位i=3,前面填了12就是相等，否则不相等
        //如果前面有填数字，那么就可以用memo
        if(!islimit && isNum && memo[i][mask]!=-1){
            return memo[i][mask];
        }
        int res=0;
        //这个位不填，放弃
        if(!isNum){
            res=countSpecialNumbershelper(i+1,mask,false,isNum,s,memo);
        }
        int up=islimit?s[i]-'0':9;
        for(int k= isNum?0:1;k<=up;k++){
            //就证明k这个数字没有被选过
            if((mask>>k &1)==0){
                res+=countSpecialNumbershelper(i+1,mask |1<<k,islimit &k==up,true,s,memo);
            }
        }
        if(!islimit && isNum){
            memo[i][mask]=res;
        }
        return res;
    }
    public static void main(String[] args) {
        int a=20;
        int ans=countSpecialNumbers(a);
        System.out.println(ans);
    }
}

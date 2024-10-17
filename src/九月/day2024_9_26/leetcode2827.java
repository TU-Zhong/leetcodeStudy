package 九月.day2024_9_26;

import java.util.Arrays;

public class leetcode2827 {
    //第一个坑，相减的时候没考虑low本身，这是个大坑
    public static int numberOfBeautifulIntegers(int low, int high, int k) {
        return nhelper(high,k)-nhelper(low-1,k);
    }
    private static char[] s;
    private static int k;
    public static int nhelper(int n,int k1){
        s=String.valueOf(n).toCharArray();
        k=k1;
        int[][][] memo=new int[s.length+1][k+1][2*s.length+1];
        for(int[][] c:memo){
            for(int[] b:c){
                Arrays.fill(b,-1);
            }
        }
        return nhelper2(0,0,s.length,true,false,memo);
    }
    //i是当前的数位，val是当前已构建数取余k的余数，minus是当前数偶数位和奇数位的数目之差
    public static int nhelper2(int i,int val,int minus,boolean islimit,boolean isNum,int[][][] memo){
        if(i==s.length){
            return isNum&&minus==s.length && val==0?1:0;
        }
        if(!islimit && isNum && memo [i][val][minus]!=-1){
            return memo[i][val][minus];
        }
        int res=0;
        if(!isNum){
            res+=nhelper2(i+1,val,minus,false,isNum,memo);
        }
        int up=islimit?s[i]-'0':9;
        for(int d=isNum?0:1;d<=up;d++){
            //取模也是一个大坑
            res+=nhelper2(i+1,(val*10+d%k)%k,minus+(d%2==0?1:-1),islimit&&d==up,true,memo);
        }
        //这里当!islimit和isNum的时候才进行记忆化，这很重要
        if(!islimit&&isNum){
            memo[i][val][minus]=res;
        }
        return res;
    }

    public static void main(String[] args) {
        int ans=numberOfBeautifulIntegers(349863935,772153463,11);
        System.out.println(ans);
    }
}

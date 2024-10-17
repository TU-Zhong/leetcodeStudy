package 九月.day2024_9_23;

import java.util.Arrays;

public class leetcode902 {
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        char[] s=String.valueOf(n).toCharArray();
        int[] b=new int[digits.length];
        for(int i=0;i<digits.length;i++){
            b[i]=Integer.parseInt(digits[i]);
        }
        Arrays.sort(b);
        return athelper(0,true,false,s,b);
    }
    public static int athelper(int i,boolean islimit,boolean isNum,char[] s,int[] digit){
        if( i==s.length ){
            return isNum?1:0;
        }
        int res=0;
        //当前位不插入数字
        if(!isNum){
            res+=athelper(i+1,false,isNum,s,digit);
        }
        int up=islimit?s[i]-'0':9;
        for(int c:digit){
            if(c<=up){
                res+=athelper(i+1,islimit&c==up,true,s,digit);
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] a={"1","3","5","7"};
        int b=100;
        int ans=atMostNGivenDigitSet(a,b);
        System.out.println(ans);
    }
}

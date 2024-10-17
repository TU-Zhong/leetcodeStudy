package 九月.day2024_9_4;

public class leetcode2266 {
    static int MOD=1000000007;
    public int countTexts(String s) {
        int pre=0;
        int next=0;
        long ans=1;
        for(int i=0;i<s.length();i++){
            if(next==s.length()-1||s.charAt(next)!=s.charAt(next+1)){
                int num=0;
                if(s.charAt(next)=='7'||s.charAt(next)=='9'){
                    num=4;
                }else{
                    num=3;
                }
                ans=(ans%MOD)*countTextselper(next-pre+1,num)%MOD;
                pre=next+1;
                next=next+1;
            }else{
                next++;
            }
        }
        return (int)ans;
    }
    public static int countTextselper(int len,int num){
        long[] dp=new long[len+1];
        dp[len]=1;
        for(int i=len-1;i>=0;i--){
            for(int j=1;j<=num;j++){
                if(i+j<=len){
                    dp[i]=(dp[i]+dp[i+j])%MOD;
                }
            }
        }
        return (int)dp[0];
    }

}

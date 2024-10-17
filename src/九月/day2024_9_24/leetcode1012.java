package 九月.day2024_9_24;

public class leetcode1012 {
    public static int numDupDigitsAtMostN(int n) {
        char[] s=String.valueOf(n).toCharArray();
        int[] cnt=new int[10];
        return nhelper(0,cnt,true,false,s);
    }
    public static int nhelper(int i,int[] nums,boolean islimit,boolean isnum,char[] s){
        if(i==s.length ){
            for(int c:nums){
                if(c>1){
                    return 1;
                }
            }
            return 0;
        }
        int res=0;
        if(!isnum){
            res+=nhelper(i+1,nums,false,isnum,s);
        }
        int up=islimit?s[i]-'0':9;
        for(int k=isnum?0:1;k<=up;k++){
            nums[k]++;
            res+=nhelper(i+1,nums,islimit&k==up,true,s);
            nums[k]--;
        }
        return res;
    }

    public static void main(String[] args) {
        int n=1000;
        int ans=numDupDigitsAtMostN(n);
        System.out.println(ans);
    }
}

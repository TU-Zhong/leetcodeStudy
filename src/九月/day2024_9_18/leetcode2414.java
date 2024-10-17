package 九月.day2024_9_18;

public class leetcode2414 {
    public static int longestContinuousSubstring(String s) {
        int max=0;
        int[] memo=new int[s.length()];
        for(int i=0;i<s.length();i++){
            max=Math.max(max,longestContinuousSubstringhelper(s,i,'$',memo)+1);
        }
        return max;
    }
    public static int longestContinuousSubstringhelper(String s,int index,char ch,int[] memo){
        if(index>=s.length()){
            return 0;
        }
        if(memo[index]!=0){
            return memo[index];
        }
        int ans=0;
        if(ch=='$'){
            ans=longestContinuousSubstringhelper(s,index+1,s.charAt(index),memo);
        }else if(ch+1==s.charAt(index)){
            ans=1+longestContinuousSubstringhelper(s,index+1,s.charAt(index),memo);
        }else{
            return 0;
        }
        memo[index]=ans;
        return ans;
    }
    public static int longestContinuousSubstring1(String s){
        int cnt=1;
        int max=1;
        char[] ch=s.toCharArray();
        for(int i=1;i<s.length();i++){
            if(ch[i]-1==ch[i-1]){
                cnt++;
                max=Math.max(cnt,max);
            }else{
                cnt=1;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "abcde";
        int ans=longestContinuousSubstring1(s);
        System.out.println(ans);
    }
}

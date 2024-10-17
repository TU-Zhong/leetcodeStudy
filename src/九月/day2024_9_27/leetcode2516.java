package 九月.day2024_9_27;

import java.util.HashMap;

public class leetcode2516 {
    private static int[] kk=new int[3];
    public static int takeCharacters(String s, int k) {
        char[] s1=s.toCharArray();
        kk[0]=kk[1]=kk[2]=k;
        HashMap<Long,Integer> memo=new HashMap<>();
        return takeCharactershelper(s1,0,s1.length-1,memo);
    }
    public static int takeCharactershelper(char[] s,int p1,int p2,HashMap<Long,Integer> memo){
        //若已经完全检查完但是仍然没有全部匹配上
        if( p1>p2 && (kk[0]>0 || kk[1]>0 || kk[2]>0)){
            return -1;
        }
        if(kk[0]<=0 && kk[1]<=0 && kk[2]<=0){
            return 0;
        }
        long label=(long)p1<<20 |p2;
        if(memo.containsKey(label)){
            return memo.get(label);
        }
        char ch1=s[p1];
        kk[ch1-'a']--;
        //先选头部
        int ans1=takeCharactershelper(s,p1+1,p2,memo);
        if(ans1!=-1){
            ans1=1+ans1;
        }
        kk[ch1-'a']++;
        ch1=s[p2];
        kk[ch1-'a']--;
        int ans2=takeCharactershelper(s,p1,p2-1,memo);
        if(ans2!=-1){
            ans2=1+ans2;
        }
        kk[ch1-'a']++;
        memo.put(label,Math.min(ans1,ans2));
        return Math.min(ans1,ans2);
    }

    public static void main(String[] args) {
        String s="aabaaaacaabc";
        int k=2;
        int ans=takeCharacters(s,k);
        System.out.println(ans);
    }
}

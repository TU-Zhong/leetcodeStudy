package 九月.day2024_9_27;

import java.util.HashSet;
import java.util.Set;

public class leetcode1456 {
    public static int maxVowels(String s, int k) {
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int left=0;
        int len=0;
        int ans=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            if(set.contains(s.charAt(right))){
                ans++;
            }
            len=right-left+1;
            if(len>k){
                if(set.contains(s.charAt(left))){
                    ans--;
                }
                left++;
            }
            max=Math.max(max,ans);
        }
        return max;
    }

    public static void main(String[] args) {
        String s="aeiou";
        int k=2;
        int ans=maxVowels(s,k);
        System.out.println(ans);
    }
}

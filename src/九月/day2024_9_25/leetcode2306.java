package 九月.day2024_9_25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode2306 {
    public long distinctNames(String[] ideas) {
        Set<String>[] groups=new HashSet[26];
        Arrays.setAll(groups,i->new HashSet<>());
        for(String str:ideas){
            groups[str.charAt(0)-'a'].add(str.substring(1));
        }
        long ans=0;
        for(int i=1;i<26;i++){
            for(int j=0;j<i;j++){
                int m=0;
                for(String s:groups[i]){
                    if(groups[j].contains(s)){
                        m++;
                    }
                }
                ans+=(long)(groups[i].size()-m)*(groups[j].size()-m);
            }
        }
        return ans*2;
    }
}

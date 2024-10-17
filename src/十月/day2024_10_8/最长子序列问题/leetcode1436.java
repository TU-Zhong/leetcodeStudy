package 十月.day2024_10_8.最长子序列问题;

import java.util.HashSet;
import java.util.List;

public class leetcode1436 {
    public String destCity(List<List<String>> paths) {
        HashSet<String> from=new HashSet<>();
        HashSet<String> to=new HashSet<>();
        for(List<String> c:paths){
            from.add(c.getFirst());
            to.add(c.get(1));
        }
        String ans="";
        for(String c:to){
            if(!from.contains(c)){
                ans=c;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

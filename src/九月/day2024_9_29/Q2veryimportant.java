package 九月.day2024_9_29;

import java.util.HashMap;

public class Q2veryimportant {
    public static int countOfSubstrings(String word, int k){
        return helper(word,k)-helper(word,k+1);
    }
    public static int helper(String word, int k) {
        //记录辅音字母个数
        int ans=0;
        int cnt1=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        for(int right=0;right<word.length();right++){
            char ch=word.charAt(right);
            //巧妙的记录元音字母的方式，很巧妙
            if("aeiou".indexOf(ch)>=0){
                map.merge(ch,1,Integer::sum);
            }else{
                cnt1++;
            }
            //找到以当前right为右边界的时候的最小的满足要求的字符串，很明显得到的这个left是最小的字符串的左边界加1，
            //然后这个左边界左边的字符加上当前这个最小的字符都会符合题目要求，但是left是从0开始的，这也是最终为什么要得到左边界加一的left
            while(map.size()==5&&cnt1>=k){
                char ch1=word.charAt(left);
                if("aeiou".indexOf(ch1)>=0){
                    if(map.merge(ch1,-1,Integer::sum)==0){
                        map.remove(ch1);
                    }
                }else{
                    cnt1--;
                }
                left++;
            }
            ans+=left;
        }
        return ans;
    }

    public static void main(String[] args) {
        String word="aaeuoiouee";
        int k=0;
        int ans=countOfSubstrings(word,k);
        System.out.println(ans);
    }
}

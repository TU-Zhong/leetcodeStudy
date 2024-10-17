package 九月.day2024_9_20;

import java.util.Arrays;

public class leetcode2376 {
    public int countSpecialNumbers(int n) {
        int ans=0;
        int[] memo=new int[11];
        Arrays.fill(memo,9);
        //把某位之前的这些特殊数全部统计出来,比如一千之前的百位有多少个特殊数
        for(int i=2;i<memo.length;i++){
            int helper=9;
            for(int j=1;j<i;j++){
                memo[i]*=helper--;
            }
            memo[i]+=memo[i-1];
        }
        while(n>0){

        }
        return 0;
    }
}

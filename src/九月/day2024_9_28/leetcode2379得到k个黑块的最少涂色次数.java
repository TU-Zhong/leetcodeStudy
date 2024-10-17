package 九月.day2024_9_28;

public class leetcode2379得到k个黑块的最少涂色次数 {
    public int minimumRecolors(String blocks, int k) {
        int left=0;
        int cnt=0;
        int ans=Integer.MAX_VALUE/2;
        for(int right=0;right<blocks.length();right++){
            cnt+=blocks.charAt(right)=='W'?1:0;
            int len=right-left+1;
            if(len==k+1){
                if(blocks.charAt(left++)=='W'){
                    cnt--;
                }
                len--;
            }
            if(len==k){
                ans=Math.min(ans,cnt);
            }
        }
        return ans;
    }
}

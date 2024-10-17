package 九月.day2024_9_28;

public class leetcode2516每个字符至少取k次 {
    public static int takeCharacters(String s, int k) {
        //统计每个数的出现的数目
        int[] chs=new int[3];
        for(int i=0;i<s.length();i++){
            chs[s.charAt(i)-'a']++;
        }
        int left=0;
        int[] helper=new int[3];
        //首先设置maxlen为不可能的值
        int maxlen=-1;
        for(int right=0;right<s.length();right++){
            //先把新加进来的那个数据的情况加到原来的各数据统计数目中
            helper[s.charAt(right)-'a']++;
            //如果加进来的数据使得不符合要求，就删left使得最后符合要求，也可能删完了都不符合要求，这个时候就要left<=right来进行判定
            while( left<=right && ( helper[0]> chs[0]-k ||  helper[1]> chs[1]-k || helper[2] > chs[2]-k )){
                helper[s.charAt(left)-'a']--;
                left++;
            }
            //如果当前的这个子数组符合情况，那么就可以更新maxlen
            if(chs[0]-helper[0]>=k &&chs[1]-helper[1]>=k &&chs[2]-helper[2]>=k ){
                maxlen=Math.max(maxlen,right-left+1);
            }
        }
        return maxlen==-1?-1:s.length()-maxlen;
    }

    public static void main(String[] args) {
        String s="aabaaaacaabc";
        int k=2;
        int ans=takeCharacters(s,k);
        System.out.println(ans);
    }
}

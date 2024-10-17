package 九月.day2024_9_24;
//1,正难则反，至少有一个重复的数难求，那么就求各位数字都不重复的数然后再减就行了
public class leetcode1012_2important {
    private static char[] s;
    public static int numDupDigitsAtMostN(int n) {
        s=String.valueOf(n).toCharArray();
        return n-nhelper(0,0,true,false);
    }
    public static int nhelper(int i,int mask,boolean islimit,boolean isNum){
        if(i==s.length){
            //前面填了数，那么就算一个，否则不算
            return isNum?1:0;
        }
        int res=0;
        //前导零在这题中对答案有影响，因为会影响mask的值，
        if(!isNum){
            res+=nhelper(i+1,mask,false,isNum);
        }
        int up=islimit?s[i]-'0':9;
        for(int k=isNum?0:1;k<=up;k++){
            //看当前这个数字之前有没有填过，填过就跳过
            if((mask>>k&1)==0){
                res+=nhelper(i+1,mask |1<<k,islimit&k==up,true);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n=1000;
        int ans=numDupDigitsAtMostN(n);
        System.out.println(ans);
    }
}

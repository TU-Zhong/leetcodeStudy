package 九月.day2024_9_23;

public class leetcode788 {
    private static int[] a={0,0,1,-1,-1,1,1,-1,0,1};
    public static int rotatedDigits(int n) {
        char[] s=String.valueOf(n).toCharArray();
        return rotatedDigitshelper(0,0,true,s);
    }
    public static int rotatedDigitshelper(int i,int hasreverse,boolean islimit,char[] s){
        if(i==s.length){
            return hasreverse==1?1:0;
        }
        int up=islimit?s[i]-'0':9;
        int res=0;
        for(int k=0;k<=up;k++){
            res+=rotatedDigitshelper(i+1,hasreverse|a[k],islimit&k==up,s);
        }
        return res;
    }

    public static void main(String[] args) {
        int a1=10;
        int ans=rotatedDigits(a1);
        System.out.println(ans);
    }
}

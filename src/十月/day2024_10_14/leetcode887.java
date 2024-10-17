package 十月.day2024_10_14;

public class leetcode887 {
    public int superEggDrop1(int k, int n) {
        for(int i=1;;i++){
            if(nhelper(i,k)>=n){
                return i;
            }
        }
    }
    public static int nhelper(int i,int k){
        if(i==0 || k==0){
            return 0;
        }
        return nhelper(i-1,k-1)+1+nhelper(i-1,k);
    }
    public int superEggDrop(int k, int n) {
        int[][] dp=new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j]+1;
                if(dp[i][j]>=n){
                    return i;
                }
            }
        }
        return 0;
    }
}

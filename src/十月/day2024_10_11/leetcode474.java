package 十月.day2024_10_11;

public class leetcode474 {
    public int findMaxForm1(String[] strs, int m, int n) {
        int[][] nums=new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            int one=0;
            int zero=0;
            for(int k=0;k<strs[i].length();k++){
                if(strs[i].charAt(k)=='0'){
                    zero++;
                }else{
                    one++;
                }
                nums[i][0]=zero;
                nums[i][1]=one;
            }
        }
        return nhelper(nums,m,n,0);
    }
    public int nhelper(int[][] nums,int m,int n,int index){
        if(index==nums.length){
            return 0;
        }
        if(m<0||n<0){
            return -1;
        }
        if(m<nums[index][0] || n<nums[index][1]){
            return nhelper(nums,m,n,index+1);
        }
        int take=nhelper(nums,m-nums[index][0],n-nums[index][1],index+1);
        int nottake=nhelper(nums,m,n,index+1);
        return Math.max(nottake,take+1);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(String str:strs){
            int one=0;
            int zero=0;
            for(char c:str.toCharArray()){
                if(c-'0'==0){
                    zero++;
                }else{
                    one++;
                }
            }
            for(int i=m;i>=zero;i--){
                for(int j=n;j>=one;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zero][j-one]+1);
                }
            }
        }
        return dp[m][n];
    }
}

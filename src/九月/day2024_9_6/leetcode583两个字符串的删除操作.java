package 九月.day2024_9_6;

public class leetcode583两个字符串的删除操作 {
    public static int longestCommonSubsequence(String text1, String text2){
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        //先初始化最后一行，text1在左，text2在上
        for(int i=text1.length()-1;i>=0;i--){
            for(int j=text2.length()-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        for(int[] s:dp){
            for(int c:s){
                System.out.printf(c+" ");
            }
            System.out.println();
        }
//        int sum=0;
//        for(int i=0;i<text1.length();i++){
//            sum+=text1.charAt(i);
//        }
//        for(int i=0;i<text2.length();i++){
//            sum+=text2.charAt(i);
//        }
        int i=text1.length()-1;
        int j=text2.length()-1;
        int sum2=0;
        StringBuilder ans=new StringBuilder();
        while( i>=0 && j>=0 ){
            if(text1.charAt(i)==text2.charAt(j)){
//                sum2+=text1.charAt(i);
                ans.append(text1.charAt(i));
                i--;
                j--;
            }else if(i-1>=0&&j-1>=0&&dp[i-1][j]>=dp[i][j-1]){
                i--;
            }else if(i-1>=0){
                i--;
            }else{
                j--;
            }
        }
//        int result=sum-2*sum2;
//        System.out.println(result);
        System.out.println(ans.reverse());
        return text1.length()+text2.length()-2*dp[0][0];
    }

    public static void main(String[] args) {
        String str1="delete";
        String str2="leet";
        longestCommonSubsequence(str1,str2);
    }
}

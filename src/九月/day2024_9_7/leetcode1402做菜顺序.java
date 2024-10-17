package 九月.day2024_9_7;

import java.util.Arrays;

public class leetcode1402做菜顺序 {
    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return maxSatisfactionhelper(satisfaction,1,0);
    }
    public static int maxSatisfactionhelper(int[] satisfaction,int index,int i){
        if(i>=satisfaction.length){
            return 0;
        }
        //选择这道菜做
        int ans1=index*satisfaction[i]+maxSatisfactionhelper(satisfaction,index+1,i+1);
        //这道菜不做
        int ans2=maxSatisfactionhelper(satisfaction,index,i+1);
        return Math.max(ans1,ans2);
    }

    public static int maxSatisfactionhelper2(int[] satisfaction){
        Arrays.sort(satisfaction);
        int[][] dp=new int[satisfaction.length+1][satisfaction.length+1];
        //i是当前菜的序号，j是菜在菜谱的序号
        //完全根据递归函数来改，递归函数这里要求j<=satisfaction.length,但是对index没进行要求，但是我们知道index是从1开始的，所以
        //可以到satisfactio.length。然后呢，依据递归函数，ans1可直接初始化为*satisfaction[j]，后续看有没有越界，ans2就看有没有越界
        //然后两者取最大值即可，依据主函数调用，最后拿到dp[1][0]作为最终结果。
        for(int i=satisfaction.length;i>=0;i--){
            for(int j=satisfaction.length-1;j>=0;j--){
                int ans1=i*satisfaction[j];
                if(j+1<satisfaction.length && i+1<=satisfaction.length){
                     ans1+=dp[i+1][j+1];
                }
                int ans2=0;
                if(j+1<satisfaction.length){
                    ans2=dp[i][j+1];
                }

                dp[i][j]=Math.max(ans1,ans2);
            }
        }
        return dp[1][0];
    }
    public static void main(String[] args) {
        int[] nums={-1,-8,0,5,-7};
        int ans=maxSatisfaction(nums);
        int ans2=maxSatisfactionhelper2(nums);
        System.out.println(ans);
        System.out.println(ans2);
    }
}

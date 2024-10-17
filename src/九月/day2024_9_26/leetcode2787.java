package 九月.day2024_9_26;

public class leetcode2787 {
    public static int numberOfWays(int n,int x){
        return numberOfWayshelper(n,x,1);
    }
    public static int numberOfWayshelper(int target,int x,int i){
        if(target==0){
            return 1;
        }
        long round = Math.round(Math.pow(i, x));
        if((int) round >target || target<0){
            return 0;
        }
        int a=(int) round;
        int ans1=numberOfWayshelper(target-a,x,i+1);
        int ans2=numberOfWayshelper(target,x,i+1);
        return ans1+ans2;
    }
    public static int numberOfWayshelper2(int target,int x){
        int n=(int) Math.round(Math.pow(target,1.0/x))+1;
        System.out.println(n);
        long[][] dp=new long[n+1][target+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        if(Math.pow(n,x)==target){
            dp[n][target]=1;
        }
        //上面是容量
        for(int i=0;i<=target;i++){
            //下面是下标
            for(int j=n-1;j>=0;j--){
                int round = (int) Math.pow(j, x);
                //选择当前的这个数
                long ans1= round>i ? 0:dp[j+1][i-round];
                long ans2=dp[j+1][i];
                dp[j][i]=ans1+ans2;
            }
        }
        return (int)(dp[1][target]%1000000007);
    }
    public static void main(String[] args) {
        int n=10;
        int x=2;
        System.out.println(numberOfWayshelper2(n,x));
    }
}

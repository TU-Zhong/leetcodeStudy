package 九月.day2024_9_26;

public class leetcode2535 {
    public static int differenceOfSum(int[] nums) {
        int sum=0;
        int sum1=0;
        for(int c:nums){
            sum+=c;
            sum1+=digitsum(c);
        }
        return sum>sum1?sum-sum1:sum1-sum;
    }
    public static int digitsum(int n){
        int res=0;
        while(n>0){
            res+=n%10;
            n/=10;
        }
        return res;
    }
}

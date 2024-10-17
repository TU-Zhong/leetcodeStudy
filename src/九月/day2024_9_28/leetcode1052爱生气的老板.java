package 九月.day2024_9_28;

public class leetcode1052爱生气的老板 {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left=0;
        int sum=0;
        int ans=0;
        int Sum=0;
        for(int right=0;right<customers.length;right++){
            Sum+=grumpy[right]==0?customers[right]:0;
            sum+=grumpy[right]==1?customers[right]:0;
            int len=right-left+1;
            if(len==minutes+1){
                sum-=grumpy[left]==1?customers[left]:0;
                left++;
                len--;
            }
            if(len==minutes){
                ans=Math.max(ans,sum);
            }
        }
        return Sum+ans;
    }

    public static void main(String[] args) {
        int[] customers={1,0,1,2,1,1,7,5};
        int[] grumpy={0,1,0,1,0,1,0,1};
        int minute=3;
        int ans=maxSatisfied(customers,grumpy,minute);
        System.out.println(ans);
    }
}

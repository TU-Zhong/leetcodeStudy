package 十月.day2024_10_9;

public class leetcode3171 {
    public static int minimumDifference(int[] nums, int k) {
        //当前或运算的总值
        int cur=0;
        //记录的最小差值
        int Min=Integer.MAX_VALUE;
        //左端点
        int left=0;
        for(int right=0;right<nums.length;right++){
            //先更新右端点
            cur|=nums[right];
            int cur1=Math.abs(cur-k);
            while(left<=right && cur1>=Min){
                int a=~nums[left];
                cur=cur&a;
                left++;
                cur1=Math.abs(cur-k);
            }
            Min=Math.min(Min,cur1);
        }
        return Min;
    }

    public static void main(String[] args) {
        int[] nums={1,3,1,3};
        int k=2;
        int a=1;
        int d=~a;
        int b=3;
        int cur=a|b;
        int c=cur&d;
        System.out.println(c);
        int ans=minimumDifference(nums,k);
        System.out.println(ans);
    }
}

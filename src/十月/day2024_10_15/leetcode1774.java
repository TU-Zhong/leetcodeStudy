package 十月.day2024_10_15;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetcode1774 {
    private static int closest;
    public int closestCost1(int[] baseCosts, int[] toppingCosts, int target) {
        for(int c:baseCosts){
            nhelper(toppingCosts,target,0,c);
        }
        return closest;
    }
    //从当前的index开始，大于target且最接近target的数
    public static void nhelper(int[] nums,int target,int index,int current){
        if(Math.abs(target-current)<Math.abs(closest-target) ||
                Math.abs(target-current)==Math.abs(closest-target) && current<target){
            closest=current;
        }
        if(index==nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            nhelper(nums,target,i+1,nums[i]+current);
            nhelper(nums,target,i+1,2*nums[i]+current);
        }
    }
    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int max=Math.max(target,Arrays.stream(baseCosts).max().orElse(0))+ 2 * Arrays.stream(toppingCosts).max().orElse(0);
        boolean[] dp=new boolean[max+1];
        for(int c:baseCosts){
            if(c<=max){
                dp[c]=true;
            }
        }
        for(int top:toppingCosts){
            for(int j=max;j>=0;j--){
                if(dp[j]){
                    if(j+top<=max){
                        dp[j+top]=true;
                    }
                    if(j+2*top<=max){
                        dp[j+2*top]=true;
                    }
                }
            }
        }
        int closest=Integer.MAX_VALUE/2;
        for(int i=1;i<dp.length;i++){
            if(dp[i]==true){
                if(Math.abs(i-target)<Math.abs(closest-target)){
                    closest=i;
                }else if(Math.abs(i-target)==Math.abs(closest-target)){
                    if(i<closest){
                        closest=i;
                    }
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] a={1,7};
        int[] b={3,4};
        int target=10;
        System.out.println(closestCost(a,b,target));
        //1 0 0 1 1 0 1 1 1 1 1 1 1 1 1 0 1 1
    }
}

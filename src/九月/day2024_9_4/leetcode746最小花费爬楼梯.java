package 九月.day2024_9_4;

public class leetcode746最小花费爬楼梯 {
    public static int minCostClimbingStairs(int[] cost) {
        int ans1=minCostClimbingStairshelper(cost,0,cost.length);
        int ans2=minCostClimbingStairshelper(cost,1,cost.length);
        return Math.min(ans1,ans2);
    }
    //递归含义，从当前下标开始的最小花费是多少
    public static int minCostClimbingStairshelper(int[] cost,int index,int n){
        //爬楼梯：是要得到爬到顶楼的方法，所以必须要严格等于最上的那个台阶
        //而这个，到了最上层就行，不用考虑是否会超过，因为反正取最小值
        if(index>=n){
            return 0;
        }
        int ans1=cost[index]+minCostClimbingStairshelper(cost,index+1,n);
        int ans2=cost[index]+minCostClimbingStairshelper(cost,index+2,n);
        return Math.min(ans1,ans2);
    }
    public static int minCostClimbingStairshelper2(int[] cost){
        int n=cost.length;
        int[] dpformzero=new int[n+1];
        int[] dpformone=new int[n+1];
        dpformzero[n-1]=cost[n-1];
        for(int i=n-2;i>=0;i--){
            dpformzero[i]=cost[i]+Math.min(dpformzero[i+1],dpformzero[i+2]);
        }
        dpformone[n-1]=cost[n-1];
        for(int i=n-2;i>=0;i--){
            dpformone[i]=cost[i]+Math.min(dpformone[i+1],dpformone[i+2]);
        }
        return Math.min(dpformzero[0],dpformone[1]);
    }
    public static void main(String[] args) {
        int[] cost={10,15,20};
        int ans=minCostClimbingStairshelper2(cost);
        System.out.println(ans);
    }
}

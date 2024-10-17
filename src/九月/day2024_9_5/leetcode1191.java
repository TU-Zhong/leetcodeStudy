package 九月.day2024_9_5;

public class leetcode1191 {
    private static int MOD=1000000007;
    public static int kConcatenationMaxSum(int[] arr,int k){
        long currentMax=arr[0];
        long globalMax=arr[0];
        long sum=arr[0];
        //拿到最大前缀和
        long premax=0;
        long currentpremax=0;
        for(int i=0;i<arr.length;i++){
            currentpremax=(currentpremax+arr[i]);
            premax=Math.max(currentpremax,premax);
        }
        //拿到最大后缀和
        long latermax=0;
        long currentlatermax=0;
        for(int i=arr.length-1;i>=0;i--){
            currentlatermax= (currentlatermax+arr[i]);
            latermax=Math.max(currentlatermax,latermax);
        }
        for(int i=1;i<arr.length;i++){
            sum+=arr[i];
            currentMax=Math.max(currentMax+arr[i],arr[i]);
            globalMax=Math.max(globalMax,currentMax);
        }
        long maxPreandLaterSum=0;
        if(k>1){
            maxPreandLaterSum=(latermax+premax);
        }

        long ans1=globalMax;
        long ans2=0;
        if(sum>0){
            if(sum>=maxPreandLaterSum){
                ans2=(sum*k);
            }else{
                ans2=((sum*(k-2))+maxPreandLaterSum);
            }
        }
        long ans3=1;
        if(sum<0){
            ans3=(sum+maxPreandLaterSum);
        }
        long finalans=Math.max(Math.max(maxPreandLaterSum,ans3),Math.max(ans1,ans2));
        return finalans>0?(int)finalans%MOD:0;
    }

    public static void main(String[] args) {
        int[] nums={1,2};
        int ans=kConcatenationMaxSum(nums,1);
        System.out.println(ans);

    }
}
